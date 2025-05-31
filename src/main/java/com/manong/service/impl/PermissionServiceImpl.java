package com.manong.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manong.mapper.PermissionMapper;
import com.manong.entity.Permission;
import com.manong.param.PermissionParam;
import com.manong.service.PermissionService;
import com.manong.utils.ResultVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

    @Override
    public List<Permission> findPermissionListByUserId(Long userId) {
        return baseMapper.findPermissionListByUserId(userId);
    }

    @Override
    public List<Permission> findPermissionListByRoleId(Long roleId) {
        return baseMapper.findPermissionListByRoleId(roleId);
    }

    @Override
    public List<Permission> findAllMenuList() {
        return baseMapper.findAllMenuList();
    }

    @Override
    public List<Permission> findMenuListByPid(Long pid) {
        return baseMapper.findMenuListByPid(pid);
    }

    @Override
    public ResultVo getPermissionList(PermissionParam permissionParam) {
        return null;
    }

    @Override
    public ResultVo addPermission(PermissionParam permissionParam) {
        return null;
    }

    @Override
    public ResultVo editPermission(PermissionParam permissionParam) {
        return null;
    }

    @Override
    public ResultVo getParentPermissionList() {
        return null;
    }

    @Override
    public ResultVo deletePermission(Long permissionId) {
        return null;
    }

    @Override
    public ResultVo getPermissionByRoleId(Long roleId) {
        return null;
    }

    @Override
    public ResultVo getMenuList() {
        return null;
    }
}
