package com.manong.param;

import lombok.Data;

/**
 * 部门参数
 */
@Data
public class DepartmentParam {
    private Long id;
    private Long parentId;
    private String departmentName;
    private String departmentCode;
    private String departmentPhone;
    private String departmentAddress;
    private Integer orderNum;
}