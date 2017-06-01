package com.tuli.dmall.facade.user.service;

import com.tuli.dmall.facade.user.entity.User;

/**
 * Created by tuli on 2017/5/31.
 */
public interface UserQueryService {

    User getUserByAccount(String account);

}
