package com.example.mybatisdemo1.service;

import com.example.mybatisdemo1.domin.User;

import java.util.List;

/**
 * @author Jipson Liang
 * create 2019-04-15-20:30
 */
public interface UserService {
    List<User> getAllUser();
    void insert(User user);
    void delete(String id);
    void update(User user);
    void updatebyid(String id);//此方法不行，更新后所有数据编程id
}
