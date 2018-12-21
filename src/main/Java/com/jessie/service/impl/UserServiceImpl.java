package com.jessie.service.impl;

import com.jessie.dao.IUserDao;
import com.jessie.model.User;
import com.jessie.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: jessie
 * @description: 用户service实现类
 * @author: Shrimp
 * @create: 2018-12-03 14:16
 **/
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    @Override
    public User selectUser(long userId) {
        return this.userDao.selectUser(userId);
    }

    @Override
    public User getUserByUserName(String username) {
        return userDao.getUserByUserName(username);
    }

    @Override
    public User login(String username, String password) {
        //检测参数，如果不是自己断言的就抛出异常
        return null;
    }
}
