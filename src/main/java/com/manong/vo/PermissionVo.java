package com.manong.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 权限列表返回结果
 */
@Data
public class PermissionVo {
    private Long id;
    private String label;
    private Long parentId;
    private String parentName;
    private String code;
    private String path;
    private String name;
    private String url;
    private Integer type;
    private String icon;
    private Date createTime;
    private Date updateTime;
    private List<PermissionVo> children;
}