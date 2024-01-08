package com.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class CookieDemo1 extends HttpServlet {

    /*
     * ①浏览器一般允许存放300个Cookie，每个站点最多20个？
     * ②todo Cookie存取中文（URLEncoder）
     * */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
//        out.write(""); /* 直接向response中写 */

        Cookie[] cookies = request.getCookies();
        if (cookies.length == 0) {
            out.write("第一次访问");
        } else {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("lastAccessTime")) {
                    long lastAccessTime = Long.parseLong(cookies[i].getValue());
                    Date date = new Date(lastAccessTime);
                    out.write("上一次访问的时间：");
                    out.write(date.toString());
                    break;
                }
            }
        }

        /* 每一次访问重置计时 */
        Cookie cookie = new Cookie("lastAccessTime", String.valueOf(System.currentTimeMillis()));
        cookie.setMaxAge(24 * 60 * 60); /* 设置有效期 */
        response.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

}
