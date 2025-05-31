package com.manong.param;

import lombok.Data;

/**
 * 用户参数
 */
@Data
public class UserParam {
    private Long userId;
    private String username;
    private String realName;
    private String nickName;
    private String mobile;
    private String email;
    private Long departmentId;
    private Long[] roleIds;
}