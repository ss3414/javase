package com.controller;

import com.github.pagehelper.PageHelper;
import com.mapper.UserMapper;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*
 * ①（纯静态）可以通过jQuery load()引入外部HTML且共享数据
 * ②后端模板（JSP使用<c:import url=""/>）
 * */
@Controller
@RequestMapping("/tmpl")
public class TmplController {

    @Autowired
    private UserMapper userMapper;

    /************************************************************分割线************************************************************/

    /*
     * 一级模板
     * ①后端无法嵌套引入
     * */
    @RequestMapping("/main")
    public ModelAndView main() {
        String[] sortArray = {"user2.jsp", "user1.jsp"};

        PageHelper.startPage(1, 1);
        List<User> userList1 = userMapper.selectPage(new HashMap());
        PageHelper.startPage(2, 1);
        List<User> userList2 = userMapper.selectPage(new HashMap());

        Map result = new HashMap();
        result.put("sortArray", sortArray);
        result.put("userList1", userList1);
        result.put("userList2", userList2);
        return new ModelAndView("/com/tmpl/main", result);
    }

    /************************************************************半分割线******************************/

    /*
     * 二级模板
     * ①一级（纵向块级元素）通过Map.key排序，<c:import>引入
     * ②二级（横向行内元素）通过Map.value排序，append附加数据（或者jQuery load()引入）
     * */
    @RequestMapping("/main2")
    public ModelAndView main2() {
        Map sortMap = new LinkedHashMap(); /* 有序HashMap */
        sortMap.put("user1.jsp", "");
        sortMap.put("user3.jsp", new String[]{"user2", "user1"});

        PageHelper.startPage(1, 1);
        List<User> userList1 = userMapper.selectPage(new HashMap());
        PageHelper.startPage(2, 1);
        List<User> userList2 = userMapper.selectPage(new HashMap());

        Map result = new HashMap();
        result.put("sortMap", sortMap);
        result.put("userList1", userList1);
        result.put("userList2", userList2);
        return new ModelAndView("/com/tmpl/main", result);
    }

}
