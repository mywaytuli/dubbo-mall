package com.tuli.dmall.web.admin.freemarker;

import com.google.common.collect.Maps;
import com.tuli.dmall.facade.user.entity.Menu;
import com.tuli.dmall.facade.user.entity.User;
import com.tuli.dmall.facade.user.service.MenuQueryService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateMethodModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

/**
 * Created by tuli on 2017/7/22.
 */

public class AdminMenuFunction implements TemplateMethodModel {

    private Logger logger = LoggerFactory.getLogger(AdminMenuFunction.class);

    @Resource
    private MenuQueryService menuQueryService;

    @Resource
    private FreeMarkerConfigurer freemarkerConfig;

    @Override
    public Object exec(List list) {
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
        } catch (TemplateException e) {
            logger.warn("process ftl error.", e);
        } catch (IOException e) {
            logger.warn("process ftl error.", e);
        }
        return sw.toString();
    }
}
