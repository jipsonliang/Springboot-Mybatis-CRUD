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

    //插入
    int insert(UserInfo userInfo);
    int batchInsert(List<UserInfo> list);//批量插入

    //更新
    int update(UserInfo userInfo);
    int updateById(Long userInfoId, String userName, Integer age, String sex);
    int batchUpdate(List<UserInfo> list);//批量更新

    //删除
    int delete(Long userInfoId);//去掉Long userInfoId前面的@Param("userInfoId")，测试ok
    int batchDelete(List<Long> userInfoId);//批量删除



}
