package com.controller;

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
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserMapper userMapper;

    /*
     * 条件查询+分页（全后端渲染）
     * ①优点：AJAX需要先刷新页面再获得数据，后端渲染可以打开一个带数据的新页面
     * ②缺点：每次刷新（分页/查询）会重置用户输入（查询条件），刷新时需要回写用户输入
     * */
    @RequestMapping("/list")
    public ModelAndView list(
            User user, /* 条件 */
            @RequestParam(defaultValue = "1") Integer currentPage, /* 分页 */
            HttpServletRequest request) {
        /* 条件+分页查询 */
        Map select = new HashMap();
        int pageSize = 2;
        select.put("user", user);
        select.put("begin", pageSize * (currentPage - 1));
        select.put("pageSize", pageSize);
        List<User> pageList = userMapper.selectConditionPage(select);
        Integer totalRecord = userMapper.selectConditionPageCount(select);

        /* 分页Bean */
        PageBean pageBean = new PageBean(pageList, totalRecord, 2, currentPage);
        pageBean.setPageURL(request.getRequestURI());
        pageBean.setQueryBean(user); /* 回写查询条件 */

        Map result = new HashMap();
        result.put("pageBean", pageBean);
        return new ModelAndView("/com/admin/list", result);
    }

    /* 根据主键获取 */
    @ResponseBody
    @RequestMapping("/selectByPrimaryKey")
    public Map selectByPrimaryKey(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        Map result = new HashMap();
        result.put("status", 1000);
        result.put("user", user);
        return result;
    }

    /* 新增/修改AJAX */
    @ResponseBody
    @RequestMapping("/createOrUpdate")
    public ModelAndView createOrUpdate(User user) {
        if (user.getId() != null) { /* 修改 */
            userMapper.updateByPrimaryKey(user);
        } else { /* 新增 */
            userMapper.insertSelective(user);
        }
        return new ModelAndView("redirect:/admin/list");
    }

    /* 删除 */
    @ResponseBody
    @RequestMapping("/delete")
    public Map delete(Integer id) {
        userMapper.deleteByPrimaryKey(id);
        Map result = new HashMap();
        result.put("status", 1000);
        return result;
    }

}
