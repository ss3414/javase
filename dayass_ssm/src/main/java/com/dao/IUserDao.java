package com.dao;

import com.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserDao {

    int insert(User user);

    User selectById(User user);

    List<User> selectByProperty(@Param("property") String property);

}
