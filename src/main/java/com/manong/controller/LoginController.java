package com.manong.controller;

import com.manong.param.LoginParam;
import com.manong.service.UserService;
import com.manong.utils.RedisUtils;
import com.manong.utils.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录控制器
 */
@RestController
@RequestMapping("/api/user")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisUtils redisUtils;

    @PostMapping("/login")
    public ResultVo login(@RequestBody LoginParam loginParam) {
        // 验证码校验
        String code = (String) redisUtils.get(loginParam.getUuid());
        if (code == null || !code.equals(loginParam.getCode())) {
            return ResultVo.fail("验证码错误");
        }
        return userService.login(loginParam);
    }
}