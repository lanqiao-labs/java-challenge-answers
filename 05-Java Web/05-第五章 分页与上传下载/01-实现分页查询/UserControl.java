package org.lanqiao.controller;

import org.lanqiao.entity.Page;
import org.lanqiao.entity.User;
import org.lanqiao.service.UserService;
import org.lanqiao.service.serviceimpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@WebServlet("/UserControl")
public class UserControl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String methodName = request.getParameter("myrequest") ;
        // 使用反射，区分不同的请求
        try {
            Method method =  this.getClass().getDeclaredMethod(methodName,HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, request,response ) ;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    //查询全部学生信息
    protected void queryByPage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //获取前台传来的当前页码，即currentPage值
        String curPage = request.getParameter("currentPage");
        //如果curPage值为null,说明是第一次进入分页查询，则将curPage设为1
        if(curPage == null){
            curPage = "1";
        }
        int currentPageNo =  Integer.parseInt(curPage);
        //调用业务逻辑层代码
        UserService userService = new UserServiceImpl();
        //获得数据总数
        int totalCount = userService.getTotalCount();
        //获取分页帮助类
        Page pages = new Page();
        //设置页面大小，即每页显示的条数(本案例，假设每页显示4条数据)
        pages.setPageSize(10);
        //设置数据总条数
        pages.setTotalCount(totalCount);
        //获取总页数
        int totalPages = pages.getTotalPage();
        //对首页与末页进行控制：页数不能小于1，也不能大于最后一页的页数
        if(currentPageNo<1){
            currentPageNo = 1;
        }else if(currentPageNo>totalPages){
            currentPageNo = totalPages;
        }
        //设置当前页的页码
        pages.setCurrentPage(currentPageNo);
        List<User> users = userService.getStudentsListForCurrentPage(pages.getCurrentPage(),pages.getPageSize());
        //设置每页显示的集合
        pages.setUsers(users);
        //将存放当前页全部数据的对象pages，放入request作用域
        //即采用分页后，数据是通过分页帮助类Page的对象来传递的
        request.setAttribute("pages", pages);
        //跳转到首页（学生列表页）
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}