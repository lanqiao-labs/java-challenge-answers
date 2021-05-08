<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
  <title>文件列表</title>
  <link rel="stylesheet" type="text/css" href="static/css/fileList.css" />
</head>
<body text-aline="center">
<div class="wrap">
  <div class="head">
      <form action="fileListServlet" method="get" id="selectForm">
          文件名:<input type="text" name="fileName" value="${pages.parm ==null ? '' :pages.parm}" id="fileName">
          <input type="hidden" name="myrequest" value="queryByPage" >
          <input type="submit" id="selectFile" >
      </form>
  </div>
  <div class="table">
      <table class="pure-table" border="1" >
          <thead>
          <tr>
              <th>文件ID</th>
              <th>文件名</th>
              <th>文件后缀</th>
              <th>文件大小</th>
              <th>文件地址</th>
              <th>创建时间</th>
              <th>操作</th>
          </tr>
          </thead>

          <c:forEach items="${pages.list }" var="fl">
              <tr class="pure-table-odd">
                      <%-- 单击“学号”链接，可以进入修改页面 --%>
                  <td width="5%">${fl.id} </td>
                  <td width="15%">${fl.fileName}</td>
                  <td width="7%">${fl.fileSuffix}</td>
                  <td width="7%">${fl.fileSize}</td>
                  <td width="25%">${fl.fileUrl}</td>
                  <td width="15%">${fl.timeStr}</td>
                      <%--调用删除的Servlet，并通过地址重写的方式将学号传递过去  --%>
                  <td>
                      <a href="fileListServlet?myrequest=delete&id=${fl.id}">
                          <BUTTON>删除</BUTTON>
                      </a>
                      <a href="fileListServlet?myrequest=downFile&fileName=${fl.fileName}">
                          <BUTTON>下载</BUTTON>
                      </a>
                  </td>
              </tr>
          </c:forEach>
      </table>
      <%--分页列表下角标--%>
      <div class="container large">
          <div class="pagination">
              <ul>
                  <c:forEach begin="1" end="${pages.totalPage }" var="page">

                      <c:if test="${pages.currentPage==page }">
                          <li>
                              <a href="javascript:void(0);"></a>
                          </li>
                      </c:if>
                      <!-- 如果当前页不等于page那就跳转到page页 -->
                      <c:if test="${pages.currentPage!=page }">
                          <li>
                              <a href="fileListServlet?myrequest=queryByPage&currentPage=${page}&fileName=${pages.parm ==null ? '' :pages.parm}"></a>
                          </li>
                      </c:if>
                  </c:forEach>
              </ul>
          </div>
      </div>
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
