package org.lanqiao.controller;

import org.lanqiao.dao.EmployeeDao;
import org.lanqiao.entity.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findEmpByEid")
public class EmployeeControl extends HttpServlet {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取 JSP 页面传入的员工工号
        String employeeId = request.getParameter("empId");
        // 创建 Dao 层对象
        EmployeeDao ed = new EmployeeDao();
        // 通过 Dao 层对象获取用户对象
        Employee employee = ed.getEmployee(Integer.parseInt(employeeId));
        if(employee!=null){
            // 将用户对象存入请求对象
            request.setAttribute("employee",employee);
            // 转发请求
            request.getRequestDispatcher("/info.jsp").forward(request,response);
        }
    }
}
