package com.manong.param;

import lombok.Data;

/**
 * 权限参数
 */
@Data
public class PermissionParam {
    private Long permissionId;
    private String label;
    private Long parentId;
    private String code;
    private String path;
    private String name;
    private String url;
    private Integer type;
    private String icon;
}