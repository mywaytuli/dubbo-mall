package com.tuli.dmall.core.user.mapper;

import com.tuli.dmall.facade.user.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by tuli on 2017/5/31.
 */
public interface UserMapper {

    int insert(User user);

    int update(User user);

    User getById(@Param("id") String id);

    List<User> listBy(Map<String, Object> paramMap);
}
