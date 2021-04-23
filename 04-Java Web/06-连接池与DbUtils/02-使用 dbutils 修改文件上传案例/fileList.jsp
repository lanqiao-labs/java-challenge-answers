<%@ page contentType="text/html;charset=UTF-8" language="java" import="org.lanqiao.entity.FileList,java.util.List,org.lanqiao.entity.Page"%>
<%@ page import="org.lanqiao.entity.FileList" %>
<%@ page pageEncoding="utf-8" %>
<html>
    <head>
        <title>文件列表</title>
    </head>
    <style>
        a{
            text-decoration: none;
        }
    </style>
    <body text-aline="center">
    <%  // 获取带数据的分页帮助类对象
        Page pages = (Page) request.getAttribute("pages");
    %>

                    <%
                        // 总页数
                        int totalPages = pages.getTotalPage();
                        //当前页的页码
                        int pageIndex = pages.getCurrentPage();
                        //获取当前页中的学生数据集合
                        List<FileList> fileLists = pages.getList();
                        if(fileLists != null){
                            for(FileList fl : fileLists){
                    %>
                        <%-- 单击“学号”链接，可以进入修改页面 --%>

                        <a href="fileListServlet?myrequest=downFile&fileName=<%=fl.getFileName() %>">文件名：<%=fl.getFileName() %>&emsp;文件大小：<%=fl.getFileSize() %>&emsp;上传时间：<%=fl.getCreateDataTimeString() %></a><br/>
                    <%
                            }
                        }
                    %>
                </table>
                当前页数：[<%= pageIndex%>/<%=totalPages%>]
                <%
                    //只要不是首页，则都可以单击“首页”和“上一页”
                    if(pageIndex > 1){
                %>
                <%-- 通过用户点击超链接，将页码传递给Servlet --%>
                <a href="fileListServlet?myrequest=queryByPage&currentPage=1&fileName=<%=pages.getParm()==null ? "":pages.getParm() %>">首页
                </a>&nbsp;
                <a href="fileListServlet?myrequest=queryByPage&currentPage=<%= pageIndex -1%>&fileName=<%=pages.getParm()==null ? "":pages.getParm() %>">上一页
                </a>
                <%
                    }
                    //只要不是末页，则都可以单击“下一步”和“末页”
                    if(pageIndex < totalPages){
                %>
                <%-- 通过用户点击超链接，将页码传递给Servlet --%>
                <a href="fileListServlet?myrequest=queryByPage&currentPage=<%= pageIndex +1%>&fileName=<%=pages.getParm()==null ? "":pages.getParm() %>">下一页
                </a>
                <a href="fileListServlet?myrequest=queryByPage&currentPage=<%=totalPages%>&fileName=<%=pages.getParm()==null ? "":pages.getParm() %>">末页
                </a>
                <%
                    }
                %>

            </div>
            <div class="foot">
                <form id="uploadForm" name="uploadForm" action="fileListServlet" method="post" enctype="multipart/form-data">
                    选择文件：<input type="file" name="uploadFile" id="uploadFile">
                    <input type="submit" id="fileSubmit"  value="提交">
                    <input type="reset" value="重置">
                </form>
            </div>
        </div>
    </body>
</html>