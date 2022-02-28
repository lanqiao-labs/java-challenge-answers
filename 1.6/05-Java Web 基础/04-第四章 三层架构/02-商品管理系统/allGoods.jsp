<%@ page import="org.lanqiao.entity.Good" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品列表</title>
</head>
<body>
<form method="get" action="/GoodController/getGoodByName">
    <input type="text" placeholder="请输入商品名" name="goodName">
    <input type="submit" value="搜索">
</form>
<table>
    <thead>
        <tr>
            <td>商品名</td>
            <td>生产商</td>
            <td>商品价格</td>
            <td>商品状态</td>
            <td>库存量</td>
            <td>操作</td>
        </tr>
    </thead>
    <tbody>
        <%
            ArrayList<Good> goods = (ArrayList<Good>) request.getAttribute("goods");
            for(int i = 0 ;i<goods.size();i++){
                Good good = goods.get(i);
        %>
        <tr>
            <td><%=good.getGoodName()%></td>
            <td><%=good.getGoodManufacturer()%></td>
            <td><%=good.getGoodPrice()%></td>
            <td><%=good.getGoodState()==0?"未上架":good.getGoodState()==1?"已上架":"已下架"%></td>
            <td><%=good.getGoodInventory()%></td>
            <td><a href="/GoodController/deleteGood?goodId=<%= good.getGoodId()%>">删除</a></td>
        </tr>
        <%
            }
        %>
    </tbody>
</table>
<form method="get" action="/GoodController/addGood">
    <label for="goodName">商品名:</label>
    <input type="text" id="goodName" name="goodName"style="width: 100px">
    <label for="goodManufacturer">生产商:</label>
    <input type="text" id="goodManufacturer" name="goodManufacturer"style="width: 100px">
    <label for="goodPrice">价格:</label>
    <input type="text" id="goodPrice" name="goodPrice" style="width: 60px">
    <label for="goodState">商品状态:</label>
    <select type="text" id="goodState" name="goodState">
        <option value="0">未上架</option>
        <option value="1">已上架</option>
        <option value="2">已下架</option>
    </select>
    <label for="goodInventory">库存量:</label>
    <input type="text" id="goodInventory" name="goodInventory" style="width: 60px">
    <input type="submit" value="添加">
</form>
</body>
<style>
    body{
        margin: 0;
        padding: 0;
    }
    table{
        width: 720px;
        border-collapse:collapse;
    }
    thead tr{
        background-color: #aaaaaa;
        font-weight: 900;
    }
    td{
        width: 120px;
        text-align: center;
    }
    tbody tr:nth-child(even){
        background-color: #999;
        color: #ffffff;
    }
</style>
</html>