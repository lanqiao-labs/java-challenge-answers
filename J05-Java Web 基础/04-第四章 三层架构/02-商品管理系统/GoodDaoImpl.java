package org.lanqiao.dao.daoimpl;

import org.lanqiao.dao.GoodDao;
import org.lanqiao.entity.Good;
import org.lanqiao.util.DBUtil;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodDaoImpl implements GoodDao{
  /**
   * 查询所有商品
   * @return 包含所有商品的集合
   * @throws SQLException
   */
  @Override
  public List<Good> getGoods() throws SQLException {
//      准备sql
      String sql = "select * from goods";
//      调用 DBUtil 工具类
      ResultSet query = DBUtil.query(sql);
//      创建集合
      List<Good> goods = new ArrayList();
//      处理结果集，封装对象存入集合
      while (query.next()){
//          获取各个字段
          int goodId = query.getInt(1);
          String goodName = query.getString(2);
          String goodManufacturer = query.getString(3);
          BigDecimal goodPrice = query.getBigDecimal(4);
          int goodState = query.getInt(5);
          int goodInventory = query.getInt(6);
//          封装对象
          Good good = new Good(goodId,goodName,goodManufacturer,goodPrice,goodState,goodInventory);
//          存入集合
          goods.add(good);
      }
      return goods;
  }

  /**
   * 通过商品名称查询商品
   * @return 查询出的商品
   */
  @Override
  public List<Good> getGoodByName(String goodName) throws SQLException {
//      准备sql
      String sql = "select * from goods where good_name like ?";
//      调用 DBUtil 工具类传入 sql 和参数，查询结果集
      ResultSet query = DBUtil.query(sql,"%"+goodName+"%");
//      处理结果集，封装对象并返回
      List<Good> goods = new ArrayList<>();
      while (query.next()){
          Good good = new Good();
          good.setGoodId(query.getInt(1));
          good.setGoodName(query.getString(2));
          good.setGoodManufacturer(query.getString(3));
          good.setGoodPrice(query.getBigDecimal(4));
          good.setGoodState(query.getInt(5));
          good.setGoodInventory(query.getInt(6));
          goods.add(good);
      }
      return goods;
  }

  /**
   * 新增商品到数据库
   * @param good 新增的商品对象
   * @return 新增成功与否
   */
  @Override
  public boolean addGood(Good good) {
//      准备sql
      String sql = "insert into goods(good_id,good_name,good_manufacturer,good_price,good_state,good_inventory) values(null,?,?,?,?,?)";
//      调用 DBUtil 工具类传入 sql 和参数
      boolean flag = DBUtil.execute(sql,good.getGoodName(),good.getGoodManufacturer(),good.getGoodPrice(),good.getGoodState(),good.getGoodInventory());
//      将结果返回出去
      return flag;
  }

  /**
   * 通过商品 id 查询商品
   * @return 查询出的商品
   */
  @Override
  public Good getGoodByGoodId(int goodId) throws SQLException {
      //      准备sql
      String sql = "select * from goods where good_id = ?";
//      调用 DBUtil 工具类传入 sql 和参数，查询结果集
      ResultSet query = DBUtil.query(sql, goodId);
//      处理结果集，封装对象并返回
      Good good = new Good();
      while (query.next()){
          good.setGoodId(query.getInt(1));
          good.setGoodName(query.getString(2));
          good.setGoodManufacturer(query.getString(3));
          good.setGoodPrice(query.getBigDecimal(4));
          good.setGoodState(query.getInt(5));
          good.setGoodInventory(query.getInt(6));
      }
      return good;
  }

  /**
   * 通过商品 id 删除商品
   * @return 是否删除成功
   */
  @Override
  public boolean deleteGood(int goodId) {
//      准备 sql
      String sql = "delete from goods where good_id = ?";
//      调用 DBUtil 工具类传入 sql 和参数
      boolean flag = DBUtil.execute(sql, goodId);
      return flag;
  }
}