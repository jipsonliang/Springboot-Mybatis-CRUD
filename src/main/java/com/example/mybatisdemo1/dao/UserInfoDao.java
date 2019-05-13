package com.example.mybatisdemo1.dao;

import com.example.mybatisdemo1.domin.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Jipson Liang
 * create 2019-04-15-20:28
 */
public interface UserInfoDao {
//    @Select({
//            "select * from UserInfo"
//    })
    List<UserInfo> getAllUser();//采用注解方式或UserMapper XML的方式都可以实现分页查询
    UserInfo getOneUser(Long userInfoId);
    List<UserInfo> getUserByDynamicCondition(UserInfo userInfo);//多条件查询之动态SQL
    int insert(UserInfo userInfo);
    int delete(@Param("userInfoId") Long userInfoId);
    int update(UserInfo userInfo);
    int updateById(@Param("userInfoId") Long userInfoId, @Param("userName") String userName, @Param("age") String age, @Param("sex") String sex);



}
