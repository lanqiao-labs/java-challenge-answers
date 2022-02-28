package org.lanqiao.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class MyFilter implements Filter {
    private FilterConfig config;

    public void destroy() {}
    /**
          * 得到ServletContext
          * 从application中获取Map
          * 从request中得到当前客户端的IP
          * 进行统计工作，结果再保存到Map中
          */
    @SuppressWarnings("unchecked")
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ServletContext app = config.getServletContext() ;
        Map<String,Integer> map = (Map<String,Integer>)app.getAttribute("map");
        String ip = request.getRemoteAddr() ;
        if(map.containsKey(ip)) {
            int cnt = map.get(ip) ;
            map.put(ip, cnt+1) ;
        } else {
            map.put(ip, 1) ;
        }
        app.setAttribute("map", map);
        chain.doFilter(request, response); //放行
    }
    /**
          * 在服务器启动时执行此方法，且只执行一次
          */
    public void init(FilterConfig fConfig) throws ServletException {
        this.config = fConfig;
    }

}
