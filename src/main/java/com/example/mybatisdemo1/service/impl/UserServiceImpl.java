package com.example.mybatisdemo1.service.impl;

import com.example.mybatisdemo1.dao.UserInfoDao;
import com.example.mybatisdemo1.domin.UserInfo;
import com.example.mybatisdemo1.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<Map<Long, UserInfo>> batchSelectReturnMap(List<Long> list) {
        //批量查询并返回List<Map>思路：用原来的（batchSelect）批量查询结果为List<UserInfo>类型数据，
        // 在service实现类里构造出需要的返回值List<Map<Long, UserInfo>>
        //List<UserInfo>中的UserInfo作为value，UserInfo对象中的UserInfoId作为key
        //有key和value之后，就可以构造出map， 最后将map再添加到mapList中

        List<Map<Long, UserInfo>> mapList =new ArrayList();
        Map<Long, UserInfo> map = new HashMap();
        List<UserInfo> batchSelectResult = userInfoDao.batchSelect(list);
        for (UserInfo value : batchSelectResult) {
            Long key = value.getUserInfoId();
            map.put(key, value);
        }
        mapList.add(map);

        return mapList;
    }

    @Override
    public List<UserInfo> likeSelect(UserInfo userInfo) {
        return userInfoDao.likeSelect(userInfo);
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
    public int updateById(Long userInfoId, String userName, Integer age, String sex) {
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


    @Override
    public int batchUpdateOneField(List<UserInfo> list) {
        return userInfoDao.batchUpdateOneField(list);
    }

    @Override
    public int batchUpdateMultiField(List<UserInfo> list) {
        return userInfoDao.batchUpdateMultiField(list);
    }

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
