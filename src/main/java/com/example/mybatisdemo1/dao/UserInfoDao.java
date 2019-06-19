package com.example.mybatisdemo1.dao;

import com.example.mybatisdemo1.domin.UserInfo;

import java.util.List;

/**
 * @author Jipson Liang
 * create 2019-04-15-20:28
 */
public interface UserInfoDao {
    //查询
//    @Select({
//            "select * from UserInfo"
//    })
    List<UserInfo> getAllUser();//采用注解方式或UserMapper XML的方式都可以实现分页查询
    UserInfo getOneUser(Long userInfoId);
    List<UserInfo> getUserByDynamicCondition(UserInfo userInfo);//多条件查询之动态SQL
    List<UserInfo> batchSelect(List<Long> list);//批量查询
    List<UserInfo> likeSelect(UserInfo userInfo);//like模糊查询


    //插入
    Integer insert(UserInfo userInfo);
    Integer batchInsert(List<UserInfo> list);//批量插入

    //更新
    Integer update(UserInfo userInfo);
    Integer updateById(Long userInfoId, String userName, Integer age, String sex);//这里参数不加注解测试ok，UserService参数是加了注解的
    Integer batchUpdate(List<UserInfo> list);//伪批量更新（逐条更新）
    Integer batchUpdateOneField(List<UserInfo> list);//批量更新单一字段
    Integer batchUpdateMultiField(List<UserInfo> list);//批量更新多个字段

    //删除
    Integer delete(Long userInfoId);//去掉Long userInfoId前面的@Param("userInfoId")，测试ok
    Integer batchDelete(List<Long> userInfoId);//批量删除



}
