package com.tuli.dmall.facade.user.service.impl;

import com.google.common.collect.Maps;
import com.tuli.dmall.core.user.mapper.UserMapper;
import com.tuli.dmall.facade.user.entity.User;
import com.tuli.dmall.facade.user.service.UserQueryService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by tuli on 2017/5/31.
 */
@Component("userQueryService")
public class UserQueryServiceImpl implements UserQueryService {

    private static final Log log = LogFactory.getLog(UserQueryServiceImpl.class);

    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserByAccount(String account, String pwd) {
        Map<String, Object> paramMap = Maps.newHashMap();
        if(StringUtils.isNotBlank(account))
            paramMap.put("account", account);
        if(StringUtils.isNotBlank(pwd))
            paramMap.put("pwd", pwd);
        List<User> userList = userMapper.listBy(paramMap);
        if(userList.isEmpty())
            return null;
        return userList.get(0);
    }

}
