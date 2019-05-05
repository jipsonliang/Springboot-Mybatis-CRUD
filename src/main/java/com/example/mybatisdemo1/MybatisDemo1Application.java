package com.example.mybatisdemo1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.example.mybatisdemo1.dao"})
public class MybatisDemo1Application {

    public static void main(String[] args) {
        SpringApplication.run(MybatisDemo1Application.class, args);
    }

}
