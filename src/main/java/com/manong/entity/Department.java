package com.manong.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 部门实体类
 */
@Data
@TableName("sys_department")
public class Department implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String departmentName;
    private String departmentCode;
    private Long parentId;
    private String parentName;
    private Integer orderNum;
    private Date createTime;
    private Date updateTime;
    private Long createUser;
    private Integer isDelete;

    @TableField(exist = false)
    private List<Department> children;
}
