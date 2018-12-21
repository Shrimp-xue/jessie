package com.jessie.dao;


import com.jessie.model.User;

/**
 * @program: jessie
 * @description: 用户接口类
 * @author: Shrimp
 * @create: 2018-12-03 14:13
 **/
public interface IUserDao {
    /**
     * 根据用户ID查询用户
     *
     * @param id
     * @return
     */
    public User selectUser(long id);

    /**
     * 根据用户账号查询用户
     *
     * @param username
     * @return
     */
    public User getUserByUserName(String username);

    /**
     * 根据用户账号和用户密码进行登陆验证
     *
     * @param username
     * @param password
     * @return
     */
    public User login(String username, String password);

}
