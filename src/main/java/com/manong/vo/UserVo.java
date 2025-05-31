package com.manong.vo;

import lombok.Data;

import java.util.Date;

/**
 * 用户列表返回结果
 */
@Data
public class UserVo {
    private Long id;
    private String username;
    private String realName;
    private String nickName;
    private String mobile;
    private String email;
    private Long departmentId;
    private String departmentName;
    private Date createTime;
    private Date updateTime;
    private Integer status;
}