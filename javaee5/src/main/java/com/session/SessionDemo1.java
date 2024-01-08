package com.session;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionDemo1 extends HttpServlet {

    /*
     * ①第一次访问时，服务器会创建一个新的Session（范围？），并将SessionId以Cookie的方式返回给客户端
     * ②刷新后再次访问，会将存储在Cookie中的SessionId发送给服务器
     * ③Session默认超时时间30分钟（可在web.xml中设置）
     * ④todo 使用Session防止表单重复提交
     * */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String str = "Test";
        HttpSession session = request.getSession();
        session.setAttribute("str", str);

        String sessionId = session.getId();
        if (session.isNew()) {
            response.getWriter().print("session创建成功，session id：" + sessionId);
        } else {
            response.getWriter().print("服务器已存在该session，session id：" + sessionId);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

}
