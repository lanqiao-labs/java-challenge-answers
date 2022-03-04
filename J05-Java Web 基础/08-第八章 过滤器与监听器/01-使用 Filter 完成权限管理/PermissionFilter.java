package org.lanqiao.filter;

import org.lanqiao.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebFilter(filterName = "PermissionFilter", urlPatterns = {"/welcome.jsp"})
public class PermissionFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 将 ServletRequest 转为 HttpServletRequest，servletResponse 转为 HttpServletResponse
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        // 获取访问的地址
        String servletPath = request.getServletPath();
        // 获取 HttpSession
        HttpSession session = request.getSession();
        // 获取登陆的对象
        User loginUser = (User) session.getAttribute("loginUser");
        if(loginUser==null){
            // 若登录的用户为 null 表示未登录，则重定向至登录页
            response.sendRedirect("index.jsp");
        }else{
            // 获取登陆用户的权限列表
            List<String> urls = loginUser.getUrls();
            // 判断当前访问的地址是否包含在登陆用户的权限列表中
            boolean flag = urls.contains(servletPath);
            // 如果包含则通过
            if(flag){
                filterChain.doFilter(servletRequest,servletResponse);
            }else{
                // 如果不包含则重定向至错误页
                response.sendRedirect("error.jsp");
            }
        }

    }

    public void destroy() {

    }
}