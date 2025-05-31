package com.manong.controller;

import com.manong.param.PermissionParam;
import com.manong.service.PermissionService;
import com.manong.utils.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * 权限控制器
 */
@RestController
@RequestMapping("/api/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    /**
     * 获取菜单列表
     * @param permissionParam
     * @return
     */
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('sys:menu:list')")
    public ResultVo getPermissionList(PermissionParam permissionParam) {
        return permissionService.getPermissionList(permissionParam);
    }

    /**
     * 新增菜单
     * @param permissionParam
     * @return
     */
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('sys:menu:add')")
    public ResultVo addPermission(@RequestBody PermissionParam permissionParam) {
        return permissionService.addPermission(permissionParam);
    }

    /**
     * 编辑菜单
     * @param permissionParam
     * @return
     */
    @PutMapping("/edit")
    @PreAuthorize("hasAuthority('sys:menu:edit')")
    public ResultVo editPermission(@RequestBody PermissionParam permissionParam) {
        return permissionService.editPermission(permissionParam);
    }

    /**
     * 删除菜单
     * @param permissionId
     * @return
     */
    @DeleteMapping("/delete/{permissionId}")
    @PreAuthorize("hasAuthority('sys:menu:delete')")
    public ResultVo deletePermission(@PathVariable Long permissionId) {
        return permissionService.deletePermission(permissionId);
    }

    /**
     * 获取上级菜单
     * @return
     */
    @GetMapping("/parent")
    @PreAuthorize("hasAuthority('sys:menu:list')")
    public ResultVo getParentPermissionList() {
        return permissionService.getParentPermissionList();
    }

    /**
     * 根据角色ID查询权限
     * @param roleId
     * @return
     */
    @GetMapping("/getPermissionByRoleId/{roleId}")
    @PreAuthorize("hasAuthority('sys:role:assignPermission')")
    public ResultVo getPermissionByRoleId(@PathVariable Long roleId) {
        return permissionService.getPermissionByRoleId(roleId);
    }

    /**
     * 获取菜单树
     * @return
     */
    @GetMapping("/getMenuList")
    public ResultVo getMenuList() {
        return permissionService.getMenuList();
    }
}
