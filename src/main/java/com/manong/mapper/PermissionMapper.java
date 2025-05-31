package com.manong.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.manong.entity.Permission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 权限数据访问层
 */
@Repository
public interface PermissionMapper extends BaseMapper<Permission> {
    
    /**
     * 根据用户ID查询权限列表
     * @param userId 用户ID
     * @return 权限列表
     */
    List<Permission> findPermissionListByUserId(@Param("userId") Long userId);
    
    /**
     * 根据角色ID查询权限列表
     * @param roleId 角色ID
     * @return 权限列表
     */
    List<Permission> findPermissionListByRoleId(@Param("roleId") Long roleId);
    
    /**
     * 根据父ID查询权限列表
     * @param parentId 父ID
     * @return 权限列表
     */
    List<Permission> findPermissionListByParentId(@Param("parentId") Long parentId);
    
    /**
     * 查询所有菜单列表
     * @return 菜单列表
     */
    List<Permission> findMenuList();
}