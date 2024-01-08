package com.controller;

import com.mapper.UserMapper;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/com")
public class IndexController {

    @RequestMapping("/home")
    public ModelAndView home() {
        return new ModelAndView("/com/home");
    }

    /************************************************************分割线************************************************************/

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/user")
    public ModelAndView user() {
        ModelAndView view = new ModelAndView();

        User user = userMapper.selectByPrimaryKey(1);

        view.addObject("user", user);
        view.setViewName("/com/user");
        return view;
    }

}
