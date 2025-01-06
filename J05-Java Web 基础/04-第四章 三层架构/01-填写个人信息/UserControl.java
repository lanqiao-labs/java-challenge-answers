package org.lanqiao.controller;

import org.lanqiao.entity.User;
import org.lanqiao.service.UserService;
import org.lanqiao.service.serviceimpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addUserInfo")
public class UserControl extends HttpServlet {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获取数据
        String userName = request.getParameter("userName");
        int userAge = Integer.parseInt(request.getParameter("userAge"));
        int userGender = Integer.parseInt(request.getParameter("userGender"));
        String userNation = request.getParameter("userNation");
        String userEmail = request.getParameter("userEmail");
        String userPhone = request.getParameter("userPhone");
        String userAddr = request.getParameter("userAddr");
//      创建对象
        User user = new User(userName,userAge,userGender,userNation,userEmail,userPhone,userAddr);
//      创建service对象，调用方法传入业务层
        UserService us = new UserServiceImpl();
        boolean flag = us.addUser(user);
//      跳转页面
        if(flag){
            response.sendRedirect("successful.jsp");
        }else{
            response.sendRedirect("error.jsp");
        }
    }
}
