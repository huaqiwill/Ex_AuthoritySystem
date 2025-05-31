package com.manong.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.manong.entity.User;


public interface UserService extends IService<User> {

    /**
     * 通过用户名查询用户信息
     *
     * @param username
     * @return
     */
    User findUserByUserName(String username);
}
