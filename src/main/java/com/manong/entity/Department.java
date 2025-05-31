package com.manong.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;


@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_department")
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 部门编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 部门名称
     */
    @TableField("department")
    private String department;

    /**
     * 部门电话
     */
    @TableField("phone")
    private String phone;

    /**
     * 部门地址
     */
    @TableField("address")
    private String address;

    /**
     * 所属部门编号
     */
    @TableField("pid")
    private Long pid;

    /**
     * 所属部门名称
     */
    @TableField("parent_name")
    private String parentName;

    /**
     * 排序
     */
    @TableField("order_num")
    private Integer orderNum;

    /**
     * 是否删除（0-未删除，1-已删除）
     */
    @TableField("is_delete")
    private Long isDelete;


}
