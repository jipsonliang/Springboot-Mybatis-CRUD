package com.example.mybatisdemo1.controller;

/**
 * @author Jipson Liang
 * create 2019-04-15-20:28
 */

import com.example.mybatisdemo1.domin.UserInfo;
import com.example.mybatisdemo1.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/user") //每个控制类定义一个统一的链接，避免与其他控制类冲突  访问该类用：http://localhost:8080/api/user/xxx
public class WebUserController {
//    @Autowired
    @Resource
    UserService userService;

    /**
     * description： 设置使用分页
     * Usage: http://localhost:8080/api/user/getAllUser22?page=2 或 http://localhost:8080/api/user/getAllUser22?page=2&size=5
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("/getAllUser22")
    public Object getAllUser(@RequestParam(value = "page",defaultValue = "1")int page,
                                     @RequestParam(value = "size",defaultValue = "10")int size){

        return userService.getAllUser1(page, size);
    }//能返回分页数据

    @RequestMapping("/getOneUser")
    public UserInfo getOneUser(Long userInfoId){
        return userService.getOneUser(userInfoId);
    }//测试方法 浏览器输入http://localhost:8080/api/user/getOneUser?userInfoId=4

    @RequestMapping("/getUserByDynamicCondition")
    public List<UserInfo> getUserByDynamicCondition(UserInfo userInfo){
        return userService.getUserByDynamicCondition(userInfo);
    }//测试方法 浏览器输入http://localhost:8080/getUserByDynamicCondition?sex=man&age=11&userName=aa

    //添加分页的多条件查询
    @RequestMapping("/getUserByDynamicCondition1")
    public Object getUserByDynamicCondition1(UserInfo userInfo,
                                             @RequestParam(value = "page",defaultValue = "1")int page,
                                             @RequestParam(value = "size",defaultValue = "10")int size){
        return userService.getUserByDynamicCondition1(userInfo,page,size);
    }//测试方法 浏览器输入http://localhost:8080/getUserByDynamicCondition1?sex=man&page=1&size=2
    @RequestMapping("/add")
    public int save(UserInfo userInfo) {
        int a = userService.insert(userInfo);
        if(a == 1) {
            System.out.println("添加成功（控制台输出）");
        }
        return a;//这里返回给浏览器显示

    }//测试方法 浏览器输入http://localhost:8080/add?userName=haha11111&age=23&sex=男

    @RequestMapping(value="/update")
    public int update(UserInfo userInfo) {
        return userService.update(userInfo);
    }//测试方法 浏览器输入http://localhost:8080/update?userInfoId=4&userName=goodjob&age=30&sex=男

    @RequestMapping(value="/delete/{userInfoId}")
    public int delete(@PathVariable("userInfoId") Long userInfoId) {
        return userService.delete(userInfoId);
    }//测试方法 浏览器输入http://localhost:8080/delete/6

    @RequestMapping(value="/updateById")
    public int updateById(Long userInfoId, String userName, Integer age, String sex) {
        return userService.updateById(userInfoId,userName,age,sex);
    }//测试方法 浏览器输入http://localhost:8080/updateById?userInfoId=23&userName=n23&age=30&sex=男


}
