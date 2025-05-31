package com.manong.controller;

import com.manong.param.RoleParam;
import com.manong.service.RoleService;
import com.manong.utils.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * 角色控制器
 */
@RestController
@RequestMapping("/api/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 获取角色列表
     * @param roleParam
     * @return
     */
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('sys:role:list')")
    public ResultVo getRoleList(RoleParam roleParam) {
        return roleService.getRoleList(roleParam);
    }

    /**
     * 新增角色
     * @param roleParam
     * @return
     */
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('sys:role:add')")
    public ResultVo addRole(@RequestBody RoleParam roleParam) {
        return roleService.addRole(roleParam);
    }

    /**
     * 编辑角色
     * @param roleParam
     * @return
     */
    @PutMapping("/edit")
    @PreAuthorize("hasAuthority('sys:role:edit')")
    public ResultVo editRole(@RequestBody RoleParam roleParam) {
        return roleService.editRole(roleParam);
    }

    /**
     * 删除角色
     * @param roleId
     * @return
     */
    @DeleteMapping("/delete/{roleId}")
    @PreAuthorize("hasAuthority('sys:role:delete')")
    public ResultVo deleteRole(@PathVariable Long roleId) {
        return roleService.deleteRole(roleId);
    }

    /**
     * 获取角色信息
     * @param roleId
     * @return
     */
    @GetMapping("/getRoleById/{roleId}")
    @PreAuthorize("hasAuthority('sys:role:list')")
    public ResultVo getRoleById(@PathVariable Long roleId) {
        return roleService.getRoleById(roleId);
    }

    /**
     * 分配权限
     * @param roleParam
     * @return
     */
    @PostMapping("/assignPermission")
    @PreAuthorize("hasAuthority('sys:role:assignPermission')")
    public ResultVo assignPermission(@RequestBody RoleParam roleParam) {
        return roleService.assignPermission(roleParam);
    }
}
