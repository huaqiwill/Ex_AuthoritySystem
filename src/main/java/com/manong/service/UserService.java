package com.manong.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.manong.entity.User;
import com.manong.param.LoginParam;
import com.manong.param.UserParam;
import com.manong.utils.ResultVo;


public interface UserService extends IService<User> {

    /**
     * 通过用户名查询用户信息
     *
     * @param username
     * @return
     */
    User findUserByUserName(String username);

    ResultVo login(LoginParam loginParam);

    ResultVo getUserList(UserParam userParam);

    ResultVo editUser(UserParam userParam);

    ResultVo addUser(UserParam userParam);

    ResultVo getUserById(Long userId);

    ResultVo deleteUser(Long userId);

    ResultVo assignRole(UserParam userParam);

    ResultVo resetPassword(Long userId);

    ResultVo getInfo();
}
