package com.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class ListenerDemo1 implements ServletContextListener, HttpSessionListener {

    /*
     * ①实现ServletContextListener接口，对ServletContext对象的创建/销毁实现监听
     * */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    /************************************************************分割线************************************************************/

    /*
     * ①实现HttpSessionListener接口，对HttpSession对象的创建/销毁实现监听
     * */
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }

}
