package org.lanqiao.service.impl;

import org.lanqiao.dao.UserSalaryDao;
import org.lanqiao.dao.impl.UserSalaryDaoImpl;
import org.lanqiao.entity.UserSalary;
import org.lanqiao.service.UserSalaryService;
import org.lanqiao.util.JDBCUtil;

import java.sql.SQLException;

public class UserSalaryServiceImpl implements UserSalaryService {
    UserSalaryDao userSalaryDao = new UserSalaryDaoImpl();
    
    public String payRoll(int userId,double salary) {
        // 开启事务
        JDBCUtil.begin();
        try {
            // 查询管理员
            UserSalary manager = userSalaryDao.selectManager(1);
            // 查询用户对象
            UserSalary user = userSalaryDao.selectManager(userId);
            if(manager.getSalary()>=salary){
                // 管理员金额减少
                userSalaryDao.subtractSalary(manager.getSalary()-salary);
                // 员工工资增加
                userSalaryDao.addSalary(userId,user.getSalary()+salary);
                // 提交事务
                JDBCUtil.commit();
                System.out.println("提交成功");
                return "工资发放成功";
            }else{
                return "工资发放失败，管理员金额不足";
            }
        } catch (Exception throwables) {
            System.out.println("提交失败，事务回滚。");
            JDBCUtil.rollback();
            throwables.printStackTrace();
            return "出现未知错误，工资发放失败";
        }
    }
}