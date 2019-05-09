package com.example.mybatisdemo1.service;

import com.example.mybatisdemo1.domin.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Jipson Liang
 * create 2019-04-15-20:30
 */
public interface UserService {
    List<User> getAllUser();
    void insert(User user);
    void delete(Long id);
    void update(User user);
    void updateById(@Param("id") Long id, @Param("userName") String userName,
                    @Param("age") String age, @Param("sex") String sex);//要么传入对象，要么用这种方式传入参数
}
