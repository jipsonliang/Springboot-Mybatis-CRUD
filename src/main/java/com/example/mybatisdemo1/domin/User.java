package com.example.mybatisdemo1.domin;

/**
 * @author Jipson Liang
 * create 2019-04-15-20:25
 */

public class User {
    public String id;
    public String userName;
    public String age;
    public String sex;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
