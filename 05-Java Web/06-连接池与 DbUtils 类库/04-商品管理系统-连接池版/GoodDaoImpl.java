package org.lanqiao.dao.daoimpl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.lanqiao.dao.GoodDao;
import org.lanqiao.entity.Good;
import org.lanqiao.util.DBUtil;

import java.sql.SQLException;
import java.util.List;

public class GoodDaoImpl implements GoodDao{
//  创建数据源查询对象
    QueryRunner queryRunner = new QueryRunner(DBUtil.getDataSource());

    /**
     * 查询所有商品
     * @return 包含所有商品的集合
     * @throws SQLException\
     *
     */
    @Override
    public List<Good> getGoods() throws SQLException {
//      准备sql
        String sql = "select good_id goodId,good_name goodName,good_manufacturer goodManufacturer,good_price goodPrice,good_state goodState,good_inventory goodInventory from goods";
//      创建集合
        List<Good> goods = queryRunner.query(sql,new BeanListHandler<Good>(Good.class));
        return goods;
    }

    /**
     * 通过商品名称查询商品
     * @return 查询出的商品
     */
    @Override
    public List<Good> getGoodByName(String goodName) throws SQLException {
//      准备sql
        String sql = "select  good_id goodId,good_name goodName,good_manufacturer goodManufacturer,good_price goodPrice,good_state goodState,good_inventory goodInventory from goods where good_name like ?";
//      调用 DBUtil 工具类传入 sql 和参数，查询结果集
        List<Good> goods = queryRunner.query(sql,new BeanListHandler<Good>(Good.class),"%"+goodName+"%");
        return goods;
    }

    /**
     * 新增商品到数据库
     * @param good 新增的商品对象
     * @return 新增成功与否
     */
    @Override
    public boolean addGood(Good good){
//      准备sql
        String sql = "insert into goods(good_id,good_name,good_manufacturer,good_price,good_state,good_inventory) values(null,?,?,?,?,?)";
//      调用 DBUtil 工具类传入 sql 和参数
        int update = 0;
        try {
            update = queryRunner.update(sql,good.getGoodName(), good.getGoodManufacturer(), good.getGoodPrice(), good.getGoodState(), good.getGoodInventory());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//      将结果返回出去
        boolean flag = true;
        if(update<0){
            flag=false;
        }
        return flag;
    }

    /**
     * 通过商品 id 查询商品
     * @return 查询出的商品
     */
    @Override
    public Good getGoodByGoodId(int goodId) throws SQLException {
        //      准备sql
        String sql = "select  good_id goodId,good_name goodName,good_manufacturer goodManufacturer,good_price goodPrice,good_state goodState,good_inventory goodInventory from goods where good_id = ?";
//      调用 DBUtil 工具类传入 sql 和参数，查询结果集
        Good good = queryRunner.query(sql,new BeanHandler<Good>(Good.class),goodId);
        return good;
    }

    /**
     * 修改商品到数据库
     * @param good 新的商品对象
     * @return 修改成功与否
     */
    @Override
    public boolean updateGood(Good good){
//      准备sql
        String sql = "update goods set good_name = ?,good_manufacturer = ?,good_price=?,good_state=?,good_inventory=? where good_id = ?";
//      调用 DBUtil 工具类传入 sql 和参数存入数据库
        int update = 0;
        try {
            update = queryRunner.update(sql, good.getGoodName(), good.getGoodManufacturer(), good.getGoodPrice(), good.getGoodState(), good.getGoodInventory(), good.getGoodId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        boolean flag = true;
        if (update<0){
            flag =false;
        }
        return flag;
    }

    /**
     * 通过商品 id 删除商品
     * @return 是否删除成功
     */
    @Override
    public boolean deleteGood(int goodId){
//      准备 sql
        String sql = "delete from goods where good_id = ?";
//      调用 DBUtil 工具类传入 sql 和参数
        int update = 0;
        try {
            update = queryRunner.update(sql, goodId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        boolean flag = true;
        if (update<0){
            flag =false;
        }
        return flag;
    }
}