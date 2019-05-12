package com.example.mybatisdemo1.service;

import com.example.mybatisdemo1.domin.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Jipson Liang
 * create 2019-04-15-20:30
 */
public interface UserService {
    Object getAllUser1(int page, int size);
    UserInfo getOneUser(@Param("userInfoId") Long userInfoId);
    List<UserInfo> getUserByDynamicCondition(UserInfo userInfo);
    Object getUserByDynamicCondition1(UserInfo userInfo,int page, int size);//添加分页的多条件查询
    int insert(UserInfo userInfo);
    int delete(@Param("userInfoId") Long userInfoId);
    int update(UserInfo userInfo);
    int updateById(@Param("userInfoId") Long userInfoId, @Param("userName") String userName,
                    @Param("age") String age, @Param("sex") String sex);//要么传入对象，要么用@Param注解方式传入参数
}
