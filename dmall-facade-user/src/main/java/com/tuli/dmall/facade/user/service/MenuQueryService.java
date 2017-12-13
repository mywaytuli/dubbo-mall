package com.tuli.dmall.facade.user.service;

import com.tuli.dmall.facade.user.entity.Menu;

import java.util.List;

/**
 * Created by tuli on 2017/7/22.
 */
public interface MenuQueryService {

    List<Menu> getMenuList(String userId);
}
