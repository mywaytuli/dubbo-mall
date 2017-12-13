package com.tuli.dmall.web.admin.controller;

import com.google.common.collect.Maps;
import com.tuli.dmall.common.utils.CryptUtil;
import com.tuli.dmall.core.menu.ResultEnum;
import com.tuli.dmall.core.model.Result;
import com.tuli.dmall.facade.user.entity.Menu;
import com.tuli.dmall.facade.user.entity.User;
import com.tuli.dmall.facade.user.service.MenuQueryService;
import com.tuli.dmall.facade.user.service.UserQueryService;
import com.tuli.dmall.web.admin.freemarker.AdminMenuFunction;
import com.tuli.dmall.web.admin.util.IPUtil;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by tuli on 2017/6/5.
 */
@Controller
@RequestMapping("/admin/**")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    private static final String LOGIN_TOKEN = "login_token";
    private static final String ADMIN_USER = "admin_user";

    private final UserQueryService userQueryService;

    private final MenuQueryService menuQueryService;

    private final FreeMarkerConfigurer freemarkerConfig;

    @Autowired
    public LoginController(UserQueryService userQueryService, MenuQueryService menuQueryService, FreeMarkerConfigurer freemarkerConfig) {
        this.userQueryService = userQueryService;
        this.menuQueryService = menuQueryService;
        this.freemarkerConfig = freemarkerConfig;
    }

    /**
     *
     * @return 返回视图
     */
    @RequestMapping("login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "getToken", method = RequestMethod.POST)
    @ResponseBody
    public String getToken(HttpServletRequest request) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String token = IPUtil.getIp(request) + sdf.format(new Date());
        HttpSession session = request.getSession();
        session.setAttribute(LOGIN_TOKEN, token);
        return token;
    }

    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    @ResponseBody
    public Result doLogin(User user, HttpSession session) {
        Result result = new Result();
        try {
            if(user == null || StringUtils.isBlank(user.getAccount()) || StringUtils.isBlank(user.getPwd())) {
                result.setCode(ResultEnum.ERROR.getValue());
                result.setError("用户名和密码不能为空");
                return result;
            }
            User u = userQueryService.getUserByAccount(user.getAccount(), null);
            String token = (String) session.getAttribute(LOGIN_TOKEN);
            if(u == null) {
                result.setCode(ResultEnum.ERROR.getValue());
                result.setError("用户名和密码错误");
                return result;
            }
            if(StringUtils.isBlank(token) || !user.getPwd().equals(u.getPwd() + CryptUtil.sha1(token))) {
                result.setCode(ResultEnum.ERROR.getValue());
                result.setError("登录异常");
                return result;
            }
            session.setAttribute(ADMIN_USER, u);
            result.setCode(ResultEnum.SUCCESS.getValue());
        } catch (Exception e) {
            result.setCode(ResultEnum.ERROR.getValue());
            logger.error(e.getMessage());
            result.setError("登录异常");
        }
        return result;
    }

    @RequestMapping("index")
    public String index() {
        StringWriter sw = new StringWriter();
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("admin_user");
            List<Menu> menuList = menuQueryService.getMenuList(user.getId());
            Map<String, Object> pm = Maps.newHashMap();
            pm.put("request", request);
            pm.put("menuArr", menuList);
            pm.put("menu", new AdminMenuFunction());
            Template t = freemarkerConfig.getConfiguration().getTemplate("admin_menu.ftl", "utf-8");
            t.process(pm, sw);
            session.setAttribute("admin_menu", sw.toString());
        } catch (TemplateException | IOException e) {
            logger.warn("process ftl error.", e);
        }
        return "index";
    }
}
