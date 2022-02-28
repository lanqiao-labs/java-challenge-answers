package org.lanqiao.dao;

import org.lanqiao.entity.User;


import java.util.List;

public interface UserDao {
    public int getTotalCount();

    public List<User> getStudentsListForCurrentPage(int currentPage, int pageSize);
}