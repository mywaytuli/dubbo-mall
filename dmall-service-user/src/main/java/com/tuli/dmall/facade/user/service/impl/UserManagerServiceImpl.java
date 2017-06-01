package com.tuli.dmall.facade.user.service.impl;

import com.tuli.dmall.core.user.mapper.UserMapper;
import com.tuli.dmall.facade.user.entity.User;
import com.tuli.dmall.facade.user.service.UserManagerService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by tuli on 2017/5/31.
 */
@Component("userManagerService")
public class UserManagerServiceImpl implements UserManagerService {

    private static final Log log = LogFactory.getLog(UserManagerServiceImpl.class);

    @Resource
    private UserMapper userMapper;

    @Override
    public boolean insert(User user) {
        try {
            userMapper.insert(user);
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
        return true;
    }
}
