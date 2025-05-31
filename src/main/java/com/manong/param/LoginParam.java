package com.manong.param;

import lombok.Data;

/**
 * 登录参数
 */
@Data
public class LoginParam {
    private String username;
    private String password;
    private String code;
    private String uuid;
}