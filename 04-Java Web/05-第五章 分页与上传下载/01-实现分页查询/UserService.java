package org.lanqiao.service;

import org.lanqiao.entity.User;

import java.util.List;

public interface UserService {

    // 获取数据总数
    int getTotalCount();

    // 获取当前页面中全部学生的集合
    List<User> getStudentsListForCurrentPage(int currentPage, int pageSize);
}