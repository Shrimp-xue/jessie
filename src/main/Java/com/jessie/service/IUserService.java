package com.jessie.service;


import com.jessie.model.User;

/**
 * @program: jessie
 * @description: 用户service类
 * @author: Shrimp
 * @create: 2018-12-03 14:15
 **/
public interface IUserService {

    /**
     * 根据id查询用户
     *
     * @param userId
     * @return
     */
    public User selectUser(long userId);

    /**
     * 根据用户名称查询用户
     *
     * @param username
     * @return
     */
    public User getUserByUserName(String username);

    /**
     * 根据用户账号和密码验证登陆
     *
     * @param username
     * @param password
     * @return
     */
    public User login(String username, String password);
}
