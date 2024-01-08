package com.mapper;

import com.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {

    int insert(User record);

    int insertSelective(User record);

    int updateByPrimaryKey(User record);

    int updateByPrimaryKeySelective(User record);

    int deleteByPrimaryKey(Integer id);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    /************************************************************分割线************************************************************/

    List<User> selectPage(Map select);

    /* 返回count(id)的值 */
    int selectPageCount(Map select);

    /************************************************************分割线************************************************************/

    List<User> selectConditionPage(Map select);

    int selectConditionPageCount(Map select);

}
