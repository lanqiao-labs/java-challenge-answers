package org.lanqiao.listener;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyListener implements ServletContextListener {
        /**
      * 在服务器启动时创建Map，保存到ServletContext
      */
        public void contextDestroyed(ServletContextEvent sce) {}
        public void contextInitialized(ServletContextEvent sce){
            Map<String,Integer> map = new LinkedHashMap<String,Integer>() ;
            ServletContext application = sce.getServletContext() ;
            application.setAttribute("map",map) ;
        }
}