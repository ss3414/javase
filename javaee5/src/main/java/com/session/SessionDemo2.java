package com.session;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionDemo2 extends HttpServlet {

    /* 禁用Cookie，URL回写 */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        String sessionId = session.getId();

        String url = "/session/SessionDemo3";
        url = response.encodeURL(url); /* URL回写（如果浏览器禁止Cookie，encodeURL将自动附加SessionId） */
//        url = response.encodeRedirectURL(url); /* 重定向URL回写 */
        response.getWriter().print("sessionId:" + sessionId);
        response.getWriter().print("<br>" +
                "<a href=\"" + url + "\">SessionDemo3</a>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

}
