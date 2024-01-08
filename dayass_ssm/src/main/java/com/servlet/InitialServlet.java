package com.servlet;

import javax.servlet.http.HttpServlet;

public class InitialServlet extends HttpServlet {

    @Override
    public void init() {
        System.out.println("************************************************************InitialServlet.init()************************************************************");
    }

}
