package com.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {

    /*
     * （下一个拦截器/Controller）处理请求前调用，第三个参数o为（下一个拦截器/Controller）
     * 返回true继续流程（下一个拦截器/Controller）
     * 返回false中断流程，不会调用下一个拦截器/Controller（此时需要通过response告知用户）
     * */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) {
        return true;
    }

    /*
     * （上一个拦截器/Controller）处理请求后调用
     * 第三个参数o为（下一个拦截器/Controller），modelAndView为上一个处理后的结果
     * */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) {

    }

    /*
     * 在DispatcherServlet完全处理完，即视图渲染完后调用
     * */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

    }

}
