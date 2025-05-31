package com.manong.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manong.mapper.RoleMapper;
import com.manong.entity.Role;
import com.manong.param.RoleParam;
import com.manong.service.RoleService;
import com.manong.utils.ResultVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Override
    public List<Role> findRoleListByUserId(Long userId) {
        return baseMapper.findRoleListByUserId(userId);
    }

    @Override
    public boolean assignPermissions(Long roleId, List<Long> permissionIds) {
        // 先删除旧的权限关系
        baseMapper.deleteRolePermissions(roleId);
        // 再保存新的权限关系
        if (permissionIds != null && !permissionIds.isEmpty()) {
            baseMapper.saveRolePermissions(roleId, permissionIds);
        }
        return true;
    }

    @Override
    public boolean removeRolePermissions(Long roleId) {
        return baseMapper.deleteRolePermissions(roleId) > 0;
    }

    @Override
    public List<Long> findPermissionIdsByRoleId(Long roleId) {
        return baseMapper.findPermissionIdsByRoleId(roleId);
    }

    @Override
    public ResultVo getRoleList(RoleParam roleParam) {
        return null;
    }

    @Override
    public ResultVo addRole(RoleParam roleParam) {
        return null;
    }

    @Override
    public ResultVo editRole(RoleParam roleParam) {
        return null;
    }

    @Override
    public ResultVo deleteRole(Long roleId) {
        return null;
    }

    @Override
    public ResultVo getRoleById(Long roleId) {
        return null;
    }

    @Override
    public ResultVo assignPermission(RoleParam roleParam) {
        return null;
    }
}
