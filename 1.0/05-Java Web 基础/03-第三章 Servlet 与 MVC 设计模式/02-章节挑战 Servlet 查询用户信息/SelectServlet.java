package org.lanqiao.servlet;

import org.lanqiao.dao.UserDao;
import org.lanqiao.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SelectServlet extends javax.servlet.http.HttpServlet {
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     this.doGet(request,response);
 }

 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     //将请求的编码与页面保持一致，设置为UTF-8
     request.setCharacterEncoding("UTF-8");
     //接收视图传来的参数
     String name = request.getParameter("uname");
     //将参数传递到 userDao 中的 getUserByName 方法 并且传入查询参数
     UserDao userDao = new UserDao();
     User user = userDao.getUserByName(name);
     //将用户信息放入 session 中
     request.getSession().setAttribute("userInfo", user);
     //完毕后，跳转到 showUser.jsp 页面
     request.getRequestDispatcher("showUser.jsp").forward(request, response);

 }


}