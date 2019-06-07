package com.example.mybatisdemo1.service;

import com.example.mybatisdemo1.domin.UserInfo;
import com.example.mybatisdemo1.enums.UserSexEnum;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Jipson Liang
 * create 2019-04-15-20:30
 */
public interface UserService {
    //查询
    Object getAllUser0(); //不用分页查询
    Object getAllUser1(int page, int size); //分页查询
    UserInfo getOneUser(@Param("userInfoId") Long userInfoId);
    List<UserInfo> getUserByDynamicCondition(UserInfo userInfo);
    Object getUserByDynamicCondition1(UserInfo userInfo,int page, int size);//添加分页的多条件查询
    List<UserInfo> batchSelect(List<Long> list);//按ID批量查询

    //插入
    int insert(UserInfo userInfo);
    int batchInsert(@Param("list") List<UserInfo> list);//批量插入

    //更新
    int update(UserInfo userInfo);
    int updateById(@Param("userInfoId") Long userInfoId, @Param("userName") String userName,
                    @Param("age") Integer age, @Param("sex") UserSexEnum sex);//要么传入对象，要么用@Param注解方式传入参数
    int batchUpdate(List<UserInfo> list);//批量更新

    //删除
    int delete(Long userInfoId);//去掉Long userInfoId前面的@Param("userInfoId")，测试ok
    int batchDelete(List<Long> userInfoId);
}
