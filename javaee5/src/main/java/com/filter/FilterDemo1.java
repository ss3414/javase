package com.filter;

import javax.servlet.*;
import java.io.IOException;

/*
 * ①拦截器
 * ②Filter链
 * ③Filter生命周期
 * */
public class FilterDemo1 implements Filter {

    /* 初始化 */
    @Override
    public void init(FilterConfig config) {
        System.out.println("Filter初始化");
    }

    /* 预处理 */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print("FilterDemo1插入内容<br>");

        System.out.println("FilterDemo1执行前");
        /* 放行（执行目标请求） */
        chain.doFilter(request, response);
        System.out.println("FilterDemo1执行后");
    }

    /* 销毁 */
    @Override
    public void destroy() {
        System.out.println("Filter销毁");
    }

}
