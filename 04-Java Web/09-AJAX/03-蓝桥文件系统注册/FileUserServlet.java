package org.lanqiao.servlet;

import com.alibaba.fastjson.JSON;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.lanqiao.entity.FileList;
import org.lanqiao.entity.FileUser;
import org.lanqiao.service.FileListService;
import org.lanqiao.service.FileUserService;
import org.lanqiao.service.impl.FileListServiceImpl;
import org.lanqiao.service.impl.FileUserServiceImpl;
import org.lanqiao.util.Page;
import org.lanqiao.util.ResponseMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;


@WebServlet("/fileUserServlet")
public class FileUserServlet extends HttpServlet {
    //调用业务逻辑层代码
   private FileUserService fileUserService = new FileUserServiceImpl();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    /**
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String methodName = req.getParameter("myrequest") ;
        // 使用反射，区分不同的请求
        try {
            Method method =  this.getClass().getDeclaredMethod(methodName,HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, req,resp ) ;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }




    /**
     * 注册
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void regestUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 需要使用 setContentType() 方法设置编码
        response.setContentType("text/html;charset=utf-8");
        //用户名
        String userName = request.getParameter("r_user_name");
        //密码
        String userPass = request.getParameter("r_password");
        //邮箱
        String userEmail = request.getParameter("r_email");
        //创建用户实体
        FileUser fileUser = new FileUser(userName,userPass,userEmail);
        //返回实体类
        ResponseMessage rm = new ResponseMessage();
        rm=  fileUserService.registUser(fileUser,rm);
        //将返回对象转换成json
        String reslut=JSON.toJSONString(rm);//关键
        //将数据写入流中
        response.getWriter().write(reslut);
    }
    /**
     * 登录
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 需要使用 setContentType() 方法设置编码
        response.setContentType("text/html;charset=utf-8");
        //用户名
        String userName = request.getParameter("user_name");
        //密码
        String userPass = request.getParameter("user_pass");
        //创建用户实体
        FileUser fileUser = new FileUser(userName,userPass);
        //返回实体类
        ResponseMessage rm = new ResponseMessage();
        rm=  fileUserService.loginUser(fileUser,rm);
        //将返回对象转换成json
        String reslut=JSON.toJSONString(rm);//关键
        //将数据写入流中
        response.getWriter().write(reslut);
    }

}