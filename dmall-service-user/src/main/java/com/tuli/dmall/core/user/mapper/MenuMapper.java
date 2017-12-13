package com.tuli.dmall.core.user.mapper;

import com.tuli.dmall.facade.user.entity.Menu;

import java.util.List;

/**
 * Created by tuli on 2017/7/22.
 */
public interface MenuMapper {

    List<Menu> getMenuList(String userId);
}
