package com.manong.vo;

import lombok.Data;

import java.util.Date;

/**
 * 角色列表返回结果
 */
@Data
public class RoleVo {
    private Long id;
    private String roleCode;
    private String roleName;
    private String remark;
    private Date createTime;
    private Date updateTime;
}