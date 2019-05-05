package com.example.mybatisdemo1.dao;

import com.example.mybatisdemo1.domin.User;

import java.util.List;

/**
 * @author Jipson Liang
 * create 2019-04-15-20:28
 */
public interface UserDao {
    List<User> getAllUser();
    void insert(User user);
    void delete(String id);
    void update(User user);
    void updatebyid(String id);

}
