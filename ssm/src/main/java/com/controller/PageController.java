package com.controller;

import com.github.pagehelper.PageHelper;
import com.mapper.UserMapper;
import com.model.PageBean;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/page")
public class PageController {

    @Autowired
    private UserMapper userMapper;

    /*
     * 手动分页（后端渲染）
     * ①用PageBean包装分页数据
     * */
    @RequestMapping("/page")
    public ModelAndView page(
            @RequestParam(defaultValue = "1") Integer currentPage,
            HttpServletRequest request) {

        Map select = new HashMap();
        int pageSize = 2;
        select.put("begin", pageSize * (currentPage - 1));
        select.put("pageSize", pageSize);
        List<User> pageList = userMapper.selectPage(select);
        Integer totalRecord = userMapper.selectPageCount(select);

        PageBean pageBean = new PageBean(pageList, totalRecord, pageSize, currentPage);
        pageBean.setPageURL(request.getRequestURI() + "?currentPage");

        Map result = new HashMap();
        result.put("pageBean", pageBean);
        return new ModelAndView("/com/page", result);
    }

    /************************************************************分割线************************************************************/

    /* 手动分页（全AJAX） */
    @RequestMapping("/page2")
    public ModelAndView page2() {
        return new ModelAndView("/com/page");
    }

    @ResponseBody
    @RequestMapping("/page2AJAX")
    public Map page2AJAX(
            @RequestParam(defaultValue = "1") Integer currentPage) {

        Map select = new HashMap();
        int pageSize = 2;
        select.put("begin", pageSize * (currentPage - 1));
        select.put("pageSize", pageSize);
        List<User> pageList = userMapper.selectPage(select);
        Integer totalRecord = userMapper.selectPageCount(select);

        PageBean pageBean = new PageBean(pageList, totalRecord, 2, currentPage);

        Map result = new HashMap();
        result.put("pageBean", pageBean);
        return result;
    }

    /************************************************************分割线************************************************************/

    /* 手动分页（MyBatis） */
    @RequestMapping("/page3")
    public ModelAndView page3() {
        return new ModelAndView("/com/page");
    }

    @ResponseBody
    @RequestMapping("/page3AJAX")
    public Map page3AJAX(@RequestParam(defaultValue = "1") Integer currentPage) {
        PageHelper.startPage(currentPage, 2); /* 替代手动传currentPage/pageSize */
        List<User> pageList = userMapper.selectPage(new HashMap());
        Integer totalRecord = userMapper.selectPageCount(new HashMap());

        PageBean pageBean = new PageBean(pageList, totalRecord, 2, currentPage);

        Map result = new HashMap();
        result.put("pageBean", pageBean);
        return result;
    }

}
