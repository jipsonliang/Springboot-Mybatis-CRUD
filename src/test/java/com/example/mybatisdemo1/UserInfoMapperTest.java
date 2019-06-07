package com.example.mybatisdemo1;

import com.example.mybatisdemo1.domin.UserInfo;
import com.example.mybatisdemo1.enums.UserSexEnum;
import com.example.mybatisdemo1.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jipson Liang
 * create 2019-05-10-15:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoMapperTest {

//    @Autowired
    @Resource
    private UserService userService;

//  测试查询
    @Test
    public void testQueryAll(){
        //非分页查询
        Object users = userService.getAllUser0();
        if (users == null ) {
            System.out.println("is null");
        } else {
            // 按toString方法输出数据
            System.out.println(users.toString());
        }
    }//测试ok

    @Test
    public void testQueryAll_split_page(){
        //分页查询
        Object users = userService.getAllUser1(1, 3);
        if (users == null ) {
            System.out.println("is null");
        } else {
            // 按toString方法输出数据
            System.out.println(users.toString());
        }
    }//测试ok

    //按ID查询
    @Test
    public void testQueryOne(){
//        UserInfo userInfo = new UserInfo();
//        userInfo.setUserInfoId(4L);
        UserInfo oneUser = userService.getOneUser(4L);
        if (oneUser == null ) {
            System.out.println("is null");
        } else {
            // 按toString方法输出数据
            System.out.println(oneUser.toString());
        }
    }//测试ok

    //批量查询
    @Test
    public void testBatchSelect(){
        List<Long> userList =new ArrayList();
        userList.add(1L);
        userList.add(2L);
        userList.add(3L);
        System.out.println(userList);

        List<UserInfo> list = userService.batchSelect(userList);
        for (UserInfo user : list) {
            System.out.println(user);
        }//批量查询，测试ok

    }

//  测试插入
    @Test
    public void testInsert(){
        //添加第一条数据
        UserInfo userInfo1 = new UserInfo();
        userInfo1.setUserName("aa11");
        userInfo1.setAge(11);
//        userInfo1.setSex("男");
        userInfo1.setSalary(2570.50);
        //设置插入指定的时间，测试成功
        try {
            userInfo1.setRegTime(new java.sql.Date(new SimpleDateFormat("yyyy/MM/dd").parse("2019/05/20").getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        userInfo1.setCompleted(Boolean.TRUE);
        userInfo1.setRemark("这是备注哦 用默认性别");
        int a = userService.insert(userInfo1);
        System.out.println("a: " + a);

        //添加第二条数据
        UserInfo userInfo2 = new UserInfo();
        userInfo2.setUserName("bb");
        userInfo2.setAge(22);
        userInfo2.setSex(UserSexEnum.SECRET);
//        userInfo2.setSalary(3257.50);
        userInfo2.setCompleted(Boolean.FALSE);
        userInfo2.setRemark("这是备注哦 嗯 对的 用默认工资");
        int b = userService.insert(userInfo2);
        System.out.println("b: " + b);

        //添加第三条数据
        UserInfo userInfo3 = new UserInfo();
        userInfo3.setUserName("cc");
        userInfo3.setAge(33);
        userInfo3.setSex(UserSexEnum.MAN);
        userInfo3.setSalary(4600.00);
//        userInfo3.setCompleted(Boolean.FALSE);
        userInfo3.setRemark("这是备注哦 嗯 对的 用默认完成情况");
        int c = userService.insert(userInfo3);
        System.out.println("c: " + c);

        int d = a + b + c;
        //测试是否三次都成功
        Assert.assertEquals(3, d);
    }//测试ok

//  测试批量插入
    @Test
    public void testBatchInsert(){
        List<UserInfo> list = new ArrayList();

        //添加第一条数据
        UserInfo userInfo1 = new UserInfo();
        userInfo1.setUserName("aa");
        userInfo1.setAge(11);
//        userInfo1.setSex("男");
        userInfo1.setSalary(2570.50);
//        userInfo1.setRegTime(2019/05/20 00:00:00);//timestamp数据如何插入？
        userInfo1.setCompleted(Boolean.TRUE);
        userInfo1.setRemark("测试动态批量插入 用默认性别");
        list.add(userInfo1);

        //添加第二条数据
        UserInfo userInfo2 = new UserInfo();
        userInfo2.setUserName("bb");
        userInfo2.setAge(22);
        userInfo2.setSex(UserSexEnum.WOMAN);
//        userInfo2.setSalary(3257.50);
        userInfo2.setCompleted(Boolean.FALSE);
        userInfo2.setRemark("测试动态批量插入 用默认工资");
        list.add(userInfo2);

        //添加第三条数据
        UserInfo userInfo3 = new UserInfo();
        userInfo3.setUserName("cc");
        userInfo3.setAge(33);
        userInfo3.setSex(UserSexEnum.MAN);
        userInfo3.setSalary(4600.00);
//        userInfo3.setCompleted(Boolean.FALSE);
        userInfo3.setRemark("测试动态批量插入 用默认完成情况");
        list.add(userInfo3);

        System.out.println(list);
        userService.batchInsert(list);


    }//测试动态批量插入成功，注意application.yml数据库设置要加上&allowMultiQueries=true


// 测试更新
    @Test
    public void testUpdate(){
        UserInfo userInfo = new UserInfo();

        System.out.println(userInfo.toString());
        //userInfo.setUserName("Liang");
        //userInfo.setAge(30);
        userInfo.setSex(UserSexEnum.WOMAN);
        userInfo.setUserInfoId(2L);
        userInfo.setSalary(2000.00);
        userInfo.setCompleted(Boolean.TRUE);
        userInfo.setRemark("更新的备注");
        int a = userService.update(userInfo);
        // 查看返回值
        System.out.println("a: "+ a );
    }//测试ok

    @Test
    public void testUpdateById(){
        UserInfo userInfo = new UserInfo();

        System.out.println(userInfo.toString());
        userInfo.setUserName("oo");
        userInfo.setAge(1);
        userInfo.setSex(UserSexEnum.MAN);
        userInfo.setUserInfoId(1L);
        int a = userService.updateById(userInfo.userInfoId, userInfo.userName, userInfo.age, userInfo.getSex());
        System.out.println("a: "+ a );

    }//与testUpdate重复， 测试ok

    // 测试批量更新
    @Test
    public void testBatchUpdate(){
        List<UserInfo> list = new ArrayList();

        UserInfo userInfo1 = new UserInfo();
        userInfo1.setUserName("Liang4");
        userInfo1.setAge(30);
//        userInfo1.setSex("男");
        userInfo1.setUserInfoId(4L);
        userInfo1.setSalary(2000.00);
        userInfo1.setCompleted(Boolean.TRUE);
        userInfo1.setRemark("批量更新的备注，用原来的性别");
        list.add(userInfo1);

        UserInfo userInfo2 = new UserInfo();
        userInfo2.setUserName("Liang5");
//        userInfo2.setAge(30);
        userInfo2.setSex(UserSexEnum.MAN);
        userInfo2.setUserInfoId(5L);
        userInfo2.setSalary(2000.00);
        userInfo2.setCompleted(Boolean.TRUE);
        userInfo2.setRemark("批量更新的备注，用原来的年龄");
        list.add(userInfo2);

        int a = userService.batchUpdate(list);
        // 查看返回值
        System.out.println("a: "+ a );
    }//批量更新成功，注意application.yml数据库设置要加上&allowMultiQueries=true

    // 测试删除
    @Test
    public void testDelete(){
        int a = userService.delete(8L);
        System.out.println(a);
    }

    // 测试批量删除
    @Test
    public void testBatchDelete(){
        List<Long> list = new ArrayList();
        list.add(4L);
        list.add(5L);
        list.add(6L);
        System.out.println(list);

        int a = userService.batchDelete(list);
        System.out.println(a);//打印印象的条数，这里输出3

    }//批量删除，测试ok




}