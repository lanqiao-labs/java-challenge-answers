package org.lanqiao.controller;

import org.lanqiao.entity.Good;
import org.lanqiao.service.GoodService;
import org.lanqiao.service.serviceimpl.GoodServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/GoodController/*")
public class GoodController extends HttpServlet {
//  创建 service 对象
  GoodService gs = new GoodServiceImpl();

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      获取访问的路径
      StringBuffer requestURL = request.getRequestURL();
//      将最后一段路径截取出来用作判断方法名
      String methonName = requestURL.substring(requestURL.lastIndexOf("/") + 1);
//      用 switch 判断该执行哪个方法。
      switch (methonName){
          case "getGoods":
              getGoods(request,response);
              break;
          case "getGoodByName":
              getGoodByName(request,response);
              break;
          case "deleteGood":
              deleteGood(request,response);
              break;
          case "addGood":
              addGood(request,response);
              break;
          default:
      }
  }

  /**
   *  新增商品
   */
  private void addGood(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      从请求中获取新增商品的所有属性
      String goodName = request.getParameter("goodName");
      String goodManufacturer = request.getParameter("goodManufacturer");
      String price = request.getParameter("goodPrice");
      String state = request.getParameter("goodState");
      String inventory = request.getParameter("goodInventory");
//      将所有数字类型的属性从字符串转为对应的数字类型，若异常则表示传入数据不可转为数字，则跳转异常页面
      try {
          double goodPrice = Double.parseDouble(price);
          int goodState = Integer.parseInt(state);
          int goodInventory = Integer.parseInt(inventory);
//          封装对象
          Good good = new Good(goodName,goodManufacturer,BigDecimal.valueOf(goodPrice),goodState,goodInventory);
          boolean flag = gs.addGood(good);
          if(flag){
              getGoods(request,response);
          }else{
              request.setAttribute("errorInfo","添加失败！商品已存在");
              request.getRequestDispatcher("/error.jsp").forward(request,response);
          }
      } catch (NumberFormatException e) {
          e.printStackTrace();
      }
  }

  /**
   *  查询所有商品
   */
  private void getGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      List<Good> goods = gs.getGoods();
      if(goods == null){
          request.setAttribute("errorInfo","数据库查询失败，请稍后重试");
          request.getRequestDispatcher("/error.jsp").forward(request,response);
      }else{
          request.setAttribute("goods",goods);
          request.getRequestDispatcher("/allGoods.jsp").forward(request,response);
      }
  }

  /**
   *  通过商品名称查询商品
   */
  private void getGoodByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String goodName = request.getParameter("goodName");
      List<Good> goodsByName = gs.getGoodByName(goodName);
      if(goodsByName.size() == 0){
          request.setAttribute("errorInfo","数据库查询失败，请稍后重试");
          request.getRequestDispatcher("/error.jsp").forward(request,response);
      }else{
//        将对象放入请求，转发至 jsp 页面
          request.setAttribute("goods",goodsByName);
          request.getRequestDispatcher("/allGoods.jsp").forward(request,response);
      }
  }

  /**
   *  删除商品
   */
  private void deleteGood(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      获取要删除的商品 id
      String id = request.getParameter("goodId");
//      判断 id 是否为数字，若为数字则继续删除，不为数字则跳转错误页
      try {
          int goodId = Integer.parseInt(id);
          boolean flag = gs.deleteGood(goodId);
          if(flag){
              getGoods(request,response);
          }else{
              request.setAttribute("errorInfo","删除失败，商品不存在");
              request.getRequestDispatcher("/error.jsp").forward(request,response);
          }
      } catch (NumberFormatException e) {
          e.printStackTrace();
      }
  }

}