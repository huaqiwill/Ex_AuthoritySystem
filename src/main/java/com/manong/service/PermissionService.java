package com.manong.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.manong.entity.Permission;

import java.util.List;

public interface PermissionService extends IService<Permission> {
    /**
     * 根据用户ID查询权限菜单列表
     *
     * @param userId
     * @return
     */
    List<Permission> findPermissionListByUserId(Long userId);
}
