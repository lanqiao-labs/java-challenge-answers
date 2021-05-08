package org.lanqiao.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class MyListener implements HttpSessionListener, ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {}

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        // 获取 application 对象
        ServletContext sc=arg0.getServletContext();
        sc.setAttribute("count", 0);
        System.out.println(1);

    }

    // session 被创建时人数自增
    @Override
    public void sessionCreated(HttpSessionEvent arg0) {
        ServletContext sc=arg0.getSession().getServletContext();
        int count=(int) sc.getAttribute("count");
        // 存储
        sc.setAttribute("count", ++count);
        System.out.println(count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent arg0) {
        ServletContext sc=arg0.getSession().getServletContext();
        int count=(int) sc.getAttribute("count");
        // 存储
        sc.setAttribute("count", --count);
        System.out.println(count);
    }

}