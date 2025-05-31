package com.manong.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_user")
public class User implements Serializable, UserDetails {

    private static final long serialVersionUID = 1L;

    /**
     * 用户编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 登录名称
     */
    @TableField("username")
    private String username;

    /**
     * 登录密码
     */
    @TableField("password")
    private String password;

    /**
     * 账号是否过期（1-未过期，0-已过期）
     */
    @TableField("is_account_non_expired")
    private boolean isAccountNonExpired = true;

    /**
     * 账户是否被锁定（1-未锁定，0-已锁定）
     */
    @TableField("is_account_non_locked")
    private boolean isAccountNonLocked = true;

    /**
     * 密码是否过期（1-未过期，0-已过期）
     */
    @TableField("is_credentials_non_expired")
    private boolean isCredentialsNonExpired = true;

    /**
     * 账户是否可用（1-可用，0-禁用）
     */
    @TableField("is_enabled")
    private boolean isEnabled = true;

    /**
     * 真实姓名
     */
    @TableField("real_name")
    private String realName;

    /**
     * 昵称
     */
    @TableField("nick_name")
    private String nickName;

    /**
     * 所属部门ID
     */
    @TableField("department_id")
    private Integer departmentId;

    /**
     * 所属部门名称
     */
    @TableField("department_name")
    private String departmentName;

    /**
     * 性别（0-男，1-女）
     */
    @TableField("gender")
    private Integer gender;

    /**
     * 电话
     */
    @TableField("phone")
    private String phone;

    /**
     * 邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 头像
     */
    @TableField("avatar")
    private String avatar;

    /**
     * 是否是管理员（1-是，0-否）
     */
    @TableField("is_admin")
    private Integer isAdmin;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 是否删除（0-可用，1-已删除）
     */
    @TableField("is_delete")
    private Integer isDelete;

    /**
     * 权限列表
     */
    @TableField(exist = false)
    Collection<? extends GrantedAuthority> authorities;

    /**
     * 查询用户权限列表
     */
    @TableField(exist = false)
    private List<Permission> permissionList;
}
