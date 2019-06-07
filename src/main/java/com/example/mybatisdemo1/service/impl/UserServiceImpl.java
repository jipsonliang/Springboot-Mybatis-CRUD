package com.example.mybatisdemo1.service.impl;

import com.example.mybatisdemo1.dao.UserInfoDao;
import com.example.mybatisdemo1.domin.UserInfo;
import com.example.mybatisdemo1.enums.UserSexEnum;
import com.example.mybatisdemo1.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Jipson Liang
 * create 2019-04-15-20:30
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserInfoDao userInfoDao;

    @Override
    public Object getAllUser1(int page, int size) {

        PageHelper.startPage(page, size);
        List<UserInfo> userList = userInfoDao.getAllUser();
        PageInfo<UserInfo> pageInfo = new PageInfo<>(userList);
        return pageInfo;

    }

    //查询
    @Override
    public Object getAllUser0() {
        return userInfoDao.getAllUser();
    }

    @Override
    public UserInfo getOneUser(Long userInfoId){
        return userInfoDao.getOneUser(userInfoId);
    }



    @Override
    public List<UserInfo> getUserByDynamicCondition(UserInfo userInfo){
        return userInfoDao.getUserByDynamicCondition(userInfo);
    }

    @Override
    public Object getUserByDynamicCondition1(UserInfo userInfo,int page, int size){
        PageHelper.startPage(page, size);
        List<UserInfo> userList = userInfoDao.getUserByDynamicCondition(userInfo);;
        PageInfo<UserInfo> pageInfo = new PageInfo<>(userList);
        return pageInfo;
    }
    @Override
    public List<UserInfo> batchSelect(List<Long> list) {
        return userInfoDao.batchSelect(list);
    }

    //插入
    @Override
    public int insert(UserInfo userInfo) {
        return userInfoDao.insert(userInfo);
    }

    @Override
    public int batchInsert(List<UserInfo> list) {
        return userInfoDao.batchInsert(list);
    }

    //更新
    @Override
    public int update(UserInfo userInfo) {
        return userInfoDao.update(userInfo);
    }

    @Override
    public int updateById(Long userInfoId, String userName, Integer age, UserSexEnum sex) {
        return userInfoDao.updateById(userInfoId, userName, age, sex);
    }

    @Override
    public int batchUpdate(List<UserInfo> list) {
        return userInfoDao.batchUpdate(list);
    }
    //    @Override
//    public int updateById(@Param("userInfoId") Long userInfoId, @Param("userName") String userName, @Param("age") String age, @Param("sex") String sex) {
//        return userInfoDao.updateById(userInfoId, userName, age, sex);
//    }//@Param("userInfoId")为多余注解，不需要

    //删除
    @Override
    public int delete(Long userInfoId) {
        return userInfoDao.delete(userInfoId);
    }

    @Override
    public int batchDelete(List<Long> userInfoId) {
        return userInfoDao.batchDelete(userInfoId);
    }
}
