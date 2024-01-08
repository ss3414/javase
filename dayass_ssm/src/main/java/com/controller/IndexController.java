package com.controller;

import com.dao.IUserDao;
import com.model.User;
import com.model.User2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("")
public class IndexController {

    @Autowired
    private IUserDao userDao;

    /* 欢迎页index，首页home */
    @RequestMapping("/home")
    public ModelAndView home() {
        return new ModelAndView("/home");
    }

    /************************************************************分割线************************************************************/

    @ResponseBody
    @RequestMapping("/insert")
    public Map insert() {
        Map result = new HashMap();
        result.put("result", userDao.insert(User.builder().name("name1").password("pwd1").build()));
        return result;
    }

    @RequestMapping("/user")
    public ModelAndView user() {
        User user = new User();
        user.setId(1);
        user = userDao.selectById(user);

        User2 user2 = new User2();
        user2.setId(user.getId());
        user2.setName(user.getName());
        user2.setPassword(user.getPassword());

        ModelAndView view = new ModelAndView();
        view.addObject("user", user2);
        view.setViewName("/user");
        return view;
    }

    /* sqlSessionTemplate版MyBatis转义符 */
    @ResponseBody
    @RequestMapping("/mybatis")
    public Map mybatis() {
        List<User> userList = userDao.selectByProperty("name");

        Map result = new HashMap();
        result.put("userList", userList);
        return result;
    }

}
