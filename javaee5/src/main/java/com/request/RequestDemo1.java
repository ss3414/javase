package com.request;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class RequestDemo1 extends HttpServlet {

    /* todo request实现请求转发 */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");

        /* 获得客户端信息 */
        System.out.println(request.getRequestURL());
        System.out.println(request.getRequestURI());
        System.out.println(request.getQueryString());
        System.out.println(request.getRemoteAddr()); /* 客户端IP地址 */
        System.out.println(request.getRemoteHost()); /* 客户端Host（主机）名 */
        System.out.println(request.getLocalAddr()); /* 服务端IP地址 */
        System.out.println(request.getLocalName()); /* 服务端Host（主机）名 */

        /* 获得客户端请求头 */
        System.out.println(request.getHeader("content-type"));
        System.out.println(request.getHeaderNames());

        /* 获得客户端请求参数 */
        System.out.println(request.getParameter("param1"));
        System.out.println(Arrays.toString(request.getParameterValues("param1")));
        System.out.println(request.getParameterMap());

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
                "<h2>RequestDemo1</h2>\n" +
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
