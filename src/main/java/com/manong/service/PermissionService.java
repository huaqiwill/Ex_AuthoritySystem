package com.manong.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.manong.entity.Permission;
import com.manong.param.PermissionParam;
import com.manong.utils.ResultVo;

import java.util.List;

/**
 * 权限服务接口
 */
public interface PermissionService extends IService<Permission> {

    /**
     * 根据用户ID查询权限列表
     * @param userId 用户ID
     * @return 权限列表
     */
    List<Permission> findPermissionListByUserId(Long userId);

    /**
     * 根据角色ID查询权限列表
     * @param roleId 角色ID
     * @return 权限列表
     */
    List<Permission> findPermissionListByRoleId(Long roleId);

    /**
     * 查询所有菜单列表
     * @return 菜单列表
     */
    List<Permission> findAllMenuList();

    /**
     * 根据父级ID查询菜单列表
     * @param pid 父级ID
     * @return 菜单列表
     */
    List<Permission> findMenuListByPid(Long pid);

    ResultVo getPermissionList(PermissionParam permissionParam);

    ResultVo addPermission(PermissionParam permissionParam);

    ResultVo editPermission(PermissionParam permissionParam);

    ResultVo getParentPermissionList();

    ResultVo deletePermission(Long permissionId);

    ResultVo getPermissionByRoleId(Long roleId);

    ResultVo getMenuList();
}
