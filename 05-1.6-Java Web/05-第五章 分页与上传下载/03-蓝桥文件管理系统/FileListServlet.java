package org.lanqiao.servlet;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.lanqiao.entity.FileList;
import org.lanqiao.service.FileListService;
import org.lanqiao.service.impl.FileListServiceImpl;
import org.lanqiao.util.Page;
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


@WebServlet("/fileListServlet")
public class FileListServlet extends HttpServlet {
    //调用业务逻辑层代码
    FileListService fileListService = new FileListServiceImpl();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
     * 上传接口
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 需要使用 setContentType() 方法设置编码
        response.setContentType("text/html;charset=utf-8");
        // 请求信息 request 中的内容是否是 multipart 类型
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        // getRealPath() 是获取实际路径
        String uploadFilePath = request.getSession().getServletContext().getRealPath("upload");
        //删除文件逻辑
        fileListService.saveFile(request, isMultipart, uploadFilePath);
        response.sendRedirect("/fileListServlet?myrequest=queryByPage");

    }


    /**
     * 删除文件接口
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //接收通过地址重写传递来的参数
        Long fileId = Long.parseLong(request.getParameter("id"));
        //获取文件保存路径
        String uploadFilePath = request.getSession().getServletContext().getRealPath("upload");
        //调用业务逻辑层代码
        fileListService.deleteFileById(fileId,uploadFilePath);
        response.sendRedirect("/fileListServlet?myrequest=queryByPage");
    }


    /**
     * 查询接口
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void queryByPage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //获取前台传来的当前页码，即 currentPage 值
        String curPage = request.getParameter("currentPage");
        // 查询参数
        String fileName = request.getParameter("fileName");
        //获取查询出来的分页列表
        Page<FileList> pageList = fileListService.getFileListForCurrentPage(curPage,fileName);
        //即采用分页后，数据是通过分页帮助类Page的对象来传递的
        request.setAttribute("pages", pageList);
        //跳转到首页
        request.getRequestDispatcher("fileList.jsp").forward(request, response);
    }

    /**
     * 下载文件接口
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void downFile(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取要下载的文件名
        String fileName = request.getParameter("fileName") ;
        // 设置消息头（下载功能需要设置 Content-Type 和 Content-Disposition ）
        response.setHeader("Content-Type", "application/octet-stream");
        // 解决中文文件名乱码情况。
        // 使用 java.net 包提供的 URLEncoder 类中的 encode()方法。该方法可以将 URL 中的字符串，以指定的编码形式输出
        response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(fileName, "utf-8"));
        InputStream input = getServletContext().getResourceAsStream("/upload/" + fileName);
        OutputStream out = response.getOutputStream();
        byte[] buffer = new byte[1024];
        int len = -1;
        while ((len = input.read(buffer)) != -1){
            out.write(buffer, 0, len);
        }
        out.close();
    }


}