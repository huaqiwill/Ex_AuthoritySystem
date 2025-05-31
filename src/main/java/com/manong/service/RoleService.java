package com.manong.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.manong.entity.Role;
import com.manong.param.RoleParam;
import com.manong.utils.ResultVo;

import java.util.List;

/**
 * 角色服务接口
 */
public interface RoleService extends IService<Role> {
    
    /**
     * 根据用户ID查询角色列表
     * @param userId 用户ID
     * @return 角色列表
     */
    List<Role> findRoleListByUserId(Long userId);
    
    /**
     * 分配权限给角色
     * @param roleId 角色ID
     * @param permissionIds 权限ID列表
     * @return 是否成功
     */
    boolean assignPermissions(Long roleId, List<Long> permissionIds);
    
    /**
     * 删除角色的权限关系
     * @param roleId 角色ID
     * @return 是否成功
     */
    boolean removeRolePermissions(Long roleId);
    
    /**
     * 根据角色ID查询权限ID列表
     * @param roleId 角色ID
     * @return 权限ID列表
     */
    List<Long> findPermissionIdsByRoleId(Long roleId);

    ResultVo getRoleList(RoleParam roleParam);

    ResultVo addRole(RoleParam roleParam);

    ResultVo editRole(RoleParam roleParam);

    ResultVo deleteRole(Long roleId);

    ResultVo getRoleById(Long roleId);

    ResultVo assignPermission(RoleParam roleParam);
}
