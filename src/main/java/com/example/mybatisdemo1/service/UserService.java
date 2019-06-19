package com.example.mybatisdemo1.service;

import com.example.mybatisdemo1.domin.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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
    List<UserInfo> batchSelect(List<Long> list);//按ID批量查询，放回list<UserInfo>
    Map<Long, UserInfo> batchSelectReturnMap(List<Long> list);//按ID批量查询,返回Map<Long, UserInfo>
    List<UserInfo> likeSelect(UserInfo userInfo);//like模糊查询


    //插入
    Integer insert(UserInfo userInfo);
    Integer batchInsert(@Param("list") List<UserInfo> list);//批量插入

    //更新
    Integer update(UserInfo userInfo);
    Integer updateById(@Param("userInfoId") Long userInfoId, @Param("userName") String userName,
                    @Param("age") Integer age, @Param("sex") String sex);//要么传入对象，要么用@Param注解方式传入参数
    Integer batchUpdate(List<UserInfo> list);//伪批量更新（逐条更新）
    Integer batchUpdateOneField(List<UserInfo> list);//单一字段批量更新
    Integer batchUpdateMultiField(List<UserInfo> list);//批量更新多个字段

    //删除
    Integer delete(Long userInfoId);//去掉Long userInfoId前面的@Param("userInfoId")，测试ok
    Integer batchDelete(List<Long> userInfoId);
}
