package com.example.mybatisdemo1.domin;

import java.util.Date;


/**
 * @author Jipson Liang
 * create 2019-04-15-20:25
 */

public class UserInfo {
    public Long userInfoId;
    public String userName;
    public Integer age;
    public String sex;
    public Double salary; //java一定要用double，用float会在校验精度上更多消耗cpu等资源
    public Date regTime;//原来用java.sql.Date，直接使用java.util.Date即可
    public Boolean completed;
    public String remark;

    public Long getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(Long userInfoId) {
        this.userInfoId = userInfoId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

//    public String getSex() {
//        return sex;
//    }
//
//    public void setSex(String sex) {
//        this.sex = sex;
//    }


    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    @Override
    public String toString() {
        return "UserInfo{" +
                "userInfoId=" + userInfoId +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", salary=" + salary +
                ", regTime=" + regTime +
                ", completed=" + completed +
                ", remark=" + remark +
                '}';
    }

}
