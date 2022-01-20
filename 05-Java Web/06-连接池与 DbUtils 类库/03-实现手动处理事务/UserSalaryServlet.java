package org.lanqiao.servlet;

import org.lanqiao.service.UserSalaryService;
import org.lanqiao.service.impl.UserSalaryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/UserSalaryServlet")
public class UserSalaryServlet extends HttpServlet {
    UserSalaryService userSalaryService = new UserSalaryServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        double salary = Double.parseDouble(request.getParameter("salary"));
        String message = userSalaryService.payRoll(userId, salary);
        request.setAttribute("message",message);
        request.getRequestDispatcher("result.jsp").forward(request,response);
    }
}