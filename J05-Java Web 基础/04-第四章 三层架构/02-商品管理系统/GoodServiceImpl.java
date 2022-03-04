package org.lanqiao.service.serviceimpl;

import org.lanqiao.dao.GoodDao;
import org.lanqiao.dao.daoimpl.GoodDaoImpl;
import org.lanqiao.entity.Good;
import org.lanqiao.service.GoodService;

import java.sql.SQLException;
import java.util.List;

public class GoodServiceImpl implements GoodService {
    GoodDao gd = new GoodDaoImpl();

    /**
     * 查询所有商品
     * @return 包含所有商品的集合
     */
    @Override
    public List<Good> getGoods() {
//      创建集合
        List<Good> goods = null;
        try {
//          获取包含所有商品的集合赋值给之前创建的集合
            goods =  gd.getGoods();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return goods;
    }

    /**
     * 通过商品名称查询商品
     * @return 查询出的商品
     */
    @Override
    public List<Good> getGoodByName(String goodName) {
        List<Good> goods = null;
        try {
            goods = gd.getGoodByName(goodName);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
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
        List<Good> goodByName = getGoodByName(good.getGoodName());
        boolean flag = false;
        for(Good goodByGoods : goodByName){
            if(goodByGoods.getGoodName().equalsIgnoreCase(good.getGoodName())){
                flag = true;
            }
        }
        if(!flag){
            return gd.addGood(good);
        }else{
            return false;
        }
    }

    /**
     * 通过商品 id 查询商品
     * @return 查询出的商品
     */
    @Override
    public Good getGoodById(int goodId) {
        Good good = null;
        try {
            good = gd.getGoodByGoodId(goodId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return good;
    }

    /**
     * 通过商品 id 删除商品
     * @return 是否删除成功
     */
    @Override
    public boolean deleteGood(int goodId) {
        Good goodById = getGoodById(goodId);
        if(goodById==null){
            return false;
        }else{
            return gd.deleteGood(goodId);
        }
    }

}