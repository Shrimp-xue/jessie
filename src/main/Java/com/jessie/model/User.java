package com.jessie.model;

import java.util.Date;

/**
 * @program: jessie
 * @description: 用户实体类
 * @author: Shrimp
 * @create: 2018-12-03 14:14
 **/
public class User {

    private long id;//用户ID
    private String email;//邮箱
    private String password;//密码
    private String username;//用户名
    private String role;//角色
    private int status;//状态
    private Date regTime;//注册时间
    private String regIp;//注册ip

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public String getRegIp() {
        return regIp;
    }

    public void setRegIp(String regIp) {
        this.regIp = regIp;
    }

}
