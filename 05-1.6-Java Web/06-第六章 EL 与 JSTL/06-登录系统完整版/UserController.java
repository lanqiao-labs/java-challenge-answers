package org.lanqiao.controller;


import org.lanqiao.entity.User;
import org.lanqiao.service.UserService;
import org.lanqiao.service.serviceimpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/User/*")
public class UserController extends HttpServlet {
  UserService us = new UserServiceImpl();

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      获取访问的路径
      StringBuffer requestURL = request.getRequestURL();
//      将最后一段路径截取出来用作判断方法名
      String methonName = requestURL.substring(requestURL.lastIndexOf("/") + 1);
//      判断请求是否为登陆
      if(methonName.equalsIgnoreCase("login")){
//          获取表单提交的用户名密码
          String username = request.getParameter("username");
          String userpwd = request.getParameter("userpwd");
//          调用业务方法实行登陆
          String loginUser = us.login(username, userpwd);
          if(loginUser!=null){
//              将登录用户存入 session 中，以便 jsp 获取。
              HttpSession session = request.getSession();
              session.setAttribute("loginUser",loginUser);
//              将请求转发到 successful 页面
              request.getRequestDispatcher("/successful.jsp").forward(request,response);
          }else{
//              登陆失败，将请求转发到 error 页面
              request.getRequestDispatcher("/error.jsp").forward(request,response);
          }

      }
  }
}