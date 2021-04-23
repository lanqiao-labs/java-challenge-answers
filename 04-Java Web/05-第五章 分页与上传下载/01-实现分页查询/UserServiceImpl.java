package org.lanqiao.service.serviceimpl;

import org.lanqiao.dao.UserDao;
import org.lanqiao.dao.daoimpl.UserDaoImpl;
import org.lanqiao.entity.User;
import org.lanqiao.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    // 获取数据总数
    public int getTotalCount() {
        return userDao.getTotalCount();
    }

    // 获取当前页面中全部学生信息的集合
    public List<User> getStudentsListForCurrentPage(int currentPage, int pageSize){
        return userDao.getStudentsListForCurrentPage(currentPage,pageSize);
    }
}