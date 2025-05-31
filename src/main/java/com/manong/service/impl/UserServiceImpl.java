package com.manong.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manong.mapper.UserMapper;
import com.manong.entity.User;
import com.manong.param.LoginParam;
import com.manong.param.UserParam;
import com.manong.service.UserService;
import com.manong.utils.ResultVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public User findUserByUserName(String username) {
        //创建条件构造器
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //用户名
        queryWrapper.eq("username", username);
        //返回查询记录
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public ResultVo login(LoginParam loginParam) {
        return null;
    }

    @Override
    public ResultVo getUserList(UserParam userParam) {
        return null;
    }

    @Override
    public ResultVo editUser(UserParam userParam) {
        return null;
    }

    @Override
    public ResultVo addUser(UserParam userParam) {
        return null;
    }

    @Override
    public ResultVo getUserById(Long userId) {
        return null;
    }

    @Override
    public ResultVo deleteUser(Long userId) {
        return null;
    }

    @Override
    public ResultVo assignRole(UserParam userParam) {
        return null;
    }

    @Override
    public ResultVo resetPassword(Long userId) {
        return null;
    }

    @Override
    public ResultVo getInfo() {
        return null;
    }
}
