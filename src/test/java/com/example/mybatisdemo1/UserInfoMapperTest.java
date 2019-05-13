package com.example.mybatisdemo1;

import com.example.mybatisdemo1.domin.UserInfo;
import com.example.mybatisdemo1.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Jipson Liang
 * create 2019-05-10-15:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoMapperTest {

    @Autowired
    private UserService userService;

    @Test
    public void testInsert(){
        //添加第一条数据
        UserInfo userInfo1 = new UserInfo();
        userInfo1.setUserName("aa");
        userInfo1.setAge("11");
        userInfo1.setSex("man");
        int a = userService.insert(userInfo1);
        System.out.println("a: " + a);

        //添加第二条数据
        UserInfo userInfo2 = new UserInfo();
        userInfo2.setUserName("bb");
        userInfo2.setAge("22");
        userInfo2.setSex("woman");
        int b = userService.insert(userInfo2);
        System.out.println("b: " + b);

        //添加第三条数据
        UserInfo userInfo3 = new UserInfo();
        userInfo3.setUserName("cc");
        userInfo3.setAge("33");
        userInfo3.setSex("man");
        int c = userService.insert(userInfo3);
        System.out.println("c: " + c);

        int d = a + b + c;
        //测试是否三次都成功
        Assert.assertEquals(3, d);
    }


    @Test
    public void testQueryAll(){
        Object users = userService.getAllUser1(1, 3);
        if (users == null ) {
            System.out.println("is null");
        } else {

            // 按toString方法输出数据
            System.out.println(users.toString());
        }
    }
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
    }


    @Test
    public void testUpdate(){
        UserInfo userInfo = new UserInfo();

        System.out.println(userInfo.toString());
        userInfo.setUserName("Liang");
        userInfo.setAge("30");
        userInfo.setSex("男");
        userInfo.setUserInfoId(4L);
        int a = userService.update(userInfo);
        // 查看返回值
        System.out.println("a: "+ a );
    }

    @Test
    public void testUpdateById(){
        UserInfo userInfo = new UserInfo();

        System.out.println(userInfo.toString());
        userInfo.setUserName("oo");
        userInfo.setAge("27");
        userInfo.setSex("男");
        userInfo.setUserInfoId(5L);
        int a = userService.updateById(userInfo.userInfoId, userInfo.userName, userInfo.age, userInfo.sex);
        System.out.println("a: "+ a );

    }


}