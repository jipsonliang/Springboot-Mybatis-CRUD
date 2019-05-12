package com.example.mybatisdemo1.mapper;

import com.example.mybatisdemo1.dao.UserInfoDao;
import com.example.mybatisdemo1.domin.UserInfo;
import com.example.mybatisdemo1.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
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
    public int insert(UserInfo userInfo) {
        return userInfoDao.insert(userInfo);
    }

    @Override
    public int delete(Long userInfoId) {
        return userInfoDao.delete(userInfoId);
    }

    @Override
    public int update(UserInfo userInfo) {
        return userInfoDao.update(userInfo);
    }

    @Override
    public int updateById(@Param("userInfoId") Long userInfoId, @Param("userName") String userName, @Param("age") String age, @Param("sex") String sex) {
        return userInfoDao.updateById(userInfoId, userName, age, sex);
    }

}
