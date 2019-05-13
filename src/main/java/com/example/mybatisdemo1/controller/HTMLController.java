package com.example.mybatisdemo1.controller;

import com.example.mybatisdemo1.domin.UserInfo;
import com.example.mybatisdemo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

/**
 * @author Jipson Liang
 * create 2019-05-11-11:22
 */
@Controller
public class HTMLController {
    @Autowired
    UserService userService;

//    @GetMapping("/form")
//    public String greetingForm(Model model) {
//        model.addAttribute("form", new UserInfo());
//        return "form";
//    }
//
//    @PostMapping("/form")
//    public String greetingSubmit(@ModelAttribute UserInfo form) {
//        return "result";
//    }//此方法执行报错Whitelabel Error Page  An error happened during template parsing (template: "class path resource [templates/result.html]")

    @GetMapping("/form")
    public String greetingForm(Model model) {
        model.addAttribute("form", new UserInfo());
        return "form";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute UserInfo form) {
        return "result";
    }


//    @PostMapping("/form")
//    public int save(UserInfo userInfo) {
//        int a = userService.insert(userInfo);
//        if(a == 1) {
//            System.out.println("添加成功（控制台输出）");
//        }
//        return a;//这里返回给浏览器显示
//
//    }//测试方法 浏览器输入http://localhost:8080/add?userName=haha11111&age=23&sex=男

    @RequestMapping("/hello")
    public String helloHtml(HashMap<String, Object> map, Model model) {
        model.addAttribute("say","欢迎欢迎,热烈欢迎");
        map.put("hello", "欢迎进入HTML页面");
        return "index";
    }

}
