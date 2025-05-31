package com.manong.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.manong.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色数据访问层
 */
@Repository
public interface RoleMapper extends BaseMapper<Role> {
    
    /**
     * 根据用户ID查询角色列表
     * @param userId 用户ID
     * @return 角色列表
     */
    List<Role> findRoleListByUserId(@Param("userId") Long userId);
    
    /**
     * 根据角色ID查询权限ID列表
     * @param roleId 角色ID
     * @return 权限ID列表
     */
    List<Long> findPermissionIdsByRoleId(@Param("roleId") Long roleId);
    
    /**
     * 保存角色权限关系
     * @param roleId 角色ID
     * @param permissionIds 权限ID列表
     * @return 影响行数
     */
    int saveRolePermissions(@Param("roleId") Long roleId, @Param("permissionIds") List<Long> permissionIds);
    
    /**
     * 删除角色权限关系
     * @param roleId 角色ID
     * @return 影响行数
     */
    int deleteRolePermissions(@Param("roleId") Long roleId);
}