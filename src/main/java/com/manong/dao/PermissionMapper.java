package com.manong.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.manong.entity.Permission;

import java.util.List;


public interface PermissionMapper extends BaseMapper<Permission> {

    /**
     * 根据用户ID查询权限菜单列表
     *
     * @param userId
     * @return
     */
    List<Permission> findPermissionListByUserId(Long userId);

}
