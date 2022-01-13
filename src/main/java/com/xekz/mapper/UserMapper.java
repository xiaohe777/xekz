package com.xekz.mapper;

import com.xekz.base.BaseMapper;
import com.xekz.bean.User;
import com.xekz.query.UserQuery;

import java.util.List;

public interface UserMapper extends BaseMapper<User,Integer> {

    List<User> selectUserByParams(UserQuery userQuery);

    User selectByIdNo(String idNo);

    int updateUser(User user);

    int deleteByIds(Integer[] ids);

    User selectById(int id);
}
