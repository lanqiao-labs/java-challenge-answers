package org.lanqiao.service.serviceimpl;

import org.lanqiao.dao.UserDao;
import org.lanqiao.entity.User;
import org.lanqiao.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public boolean addUser(User user) {
//        创建 dao 层对象，存入数据库
        UserDao ud = new UserDao();
        return ud.addUser(user);
    }
}