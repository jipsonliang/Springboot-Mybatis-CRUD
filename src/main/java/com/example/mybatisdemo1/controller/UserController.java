package com.example.mybatisdemo1.controller;

/**
 * @author Jipson Liang
 * create 2019-04-15-20:28
 */

import com.example.mybatisdemo1.domin.User;
import com.example.mybatisdemo1.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/getAllUser")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @PostMapping(value = "/insert")
    public void insert(@Param("id") Long id,
                       @Param("username") String userName,
                       @Param("age") String age,
                       @Param("sex") String sex){
        User user = new User();
        user.setId(id);
        user.setUserName(userName);
        user.setAge(age);
        user.setSex(sex);
        userService.insert(user);
    }
    @PostMapping(value = "/delete")
    public void delete(Long id){
        userService.delete(id);
    }
    @PostMapping(value = "/update")
    public void update(User user){
        userService.update(user);
    }

    @PostMapping(value = "/updateById")
    public void updateById(@Param("id") Long id, @Param("userName") String userName, @Param("age") String age, @Param("sex") String sex){
        userService.updateById(id, userName, age, sex);
    }
}
