package com.example.mybatisdemo1.dao;

import com.example.mybatisdemo1.domin.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Jipson Liang
 * create 2019-04-15-20:28
 */
public interface UserDao {
    List<User> getAllUser();
    void insert(User user);
    void delete(Long id);
    void update(User user);
    void updateById(@Param("id") Long id, @Param("userName") String userName, @Param("age") String age, @Param("sex") String sex);


}
