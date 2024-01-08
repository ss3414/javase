package com.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class ServletContextDemo3 extends HttpServlet {

    /*
     * ①获取整个Web应用/单个Servlet的初始化参数
     * ②todo 请求转发
     * ③todo 读取文件
     * ④todo 通过类装载器读取文件
     * */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletContext context = this.getServletContext();
        Enumeration initParameterNames = context.getInitParameterNames();
        String initParameter = context.getInitParameter("context-name");

        ServletConfig config = this.getServletConfig();
        String initParameter2 = config.getInitParameter("init-param");

        /* 设置response缓存时间（对于静态网页？） */
        response.setDateHeader("expires", System.currentTimeMillis() + 24 * 3600 * 1000);

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h2>" + "获取整个Web应用的初始化参数：" + initParameter + "</h2>\n" +
                "<h2>" + "获取单个Servlet的初始化参数：" + initParameter2 + "</h2>\n" +
                "</body>\n" +
                "</html>");
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

}
