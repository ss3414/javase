package com.servlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletContextDemo1 extends HttpServlet {

    /*
     * ①通过ServletContext通讯
     * ②一个Web应用中所有Servlet共享一个ServletContext对象，因此Servlet对象之间可通过ServletContext通讯
     * */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String str = "Test";
        ServletContext context = this.getServletContext();
        context.setAttribute("str", str);

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8"); /* 注意将setCharacterEncoding写在PrintWriter前 */
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h2>" + "向ServletContext写入：" + str + "</h2>\n" +
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
