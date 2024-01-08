package com.dao;

import com.model.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements IUserDao {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public int insert(User user) {
        return sqlSessionTemplate.insert("insert", user);
    }

    @Override
    public User selectById(User user) {
        return sqlSessionTemplate.selectOne("selectById", user);
    }

    @Override
    public List<User> selectByProperty(String property) {
        return sqlSessionTemplate.selectList("selectByProperty", property);
    }

}
