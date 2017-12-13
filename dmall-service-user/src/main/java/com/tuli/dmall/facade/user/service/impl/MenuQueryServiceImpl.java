package com.tuli.dmall.facade.user.service.impl;

import com.tuli.dmall.core.user.mapper.MenuMapper;
import com.tuli.dmall.facade.user.entity.Menu;
import com.tuli.dmall.facade.user.service.MenuQueryService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tuli on 2017/7/22.
 */
@Component("menuQueryService")
public class MenuQueryServiceImpl implements MenuQueryService {

    @Resource
    private MenuMapper menuMapper;

    @Override
    public List<Menu> getMenuList(String userId) {
        return menuMapper.getMenuList(userId);
    }
}
