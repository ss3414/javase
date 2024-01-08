package com.response;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseDemo1 extends HttpServlet {

    /*
     * ①response向浏览器发送数据/响应头/响应状态码（HTTP模型）
     * ②todo 文件下载（使用OutputStream流）
     * ③todo 通过设置响应头控制浏览器行为
     * ④todo URL推荐写法
     * */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /* 通过设置Header设置response格式/编码 */
        response.setHeader("content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        /* 通过OutputStream输出（与getWriter互斥？） */
//        response.getOutputStream();

        /* 通过PrintWriter输出 */
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h2>ResponseDemo1</h2>\n" +
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
