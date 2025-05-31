package com.manong.param;

import lombok.Data;

/**
 * 角色参数
 */
@Data
public class RoleParam {
    private Long roleId;
    private String roleCode;
    private String roleName;
    private String remark;
    private Long[] permissionIds;
}