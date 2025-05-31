package com.manong.controller;

import com.manong.param.UserParam;
import com.manong.service.UserService;
import com.manong.utils.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * 用户控制器
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取用户列表
     *
     * @param userParam
     * @return
     */
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('sys:user:list')")
    public ResultVo getUserList(UserParam userParam) {
        return userService.getUserList(userParam);
    }

    /**
     * 新增用户
     *
     * @param userParam
     * @return
     */
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('sys:user:add')")
    public ResultVo addUser(@RequestBody UserParam userParam) {
        return userService.addUser(userParam);
    }

    /**
     * 编辑用户
     *
     * @param userParam
     * @return
     */
    @PutMapping("/edit")
    @PreAuthorize("hasAuthority('sys:user:edit')")
    public ResultVo editUser(@RequestBody UserParam userParam) {
        return userService.editUser(userParam);
    }

    /**
     * 删除用户
     *
     * @param userId
     * @return
     */
    @DeleteMapping("/delete/{userId}")
    @PreAuthorize("hasAuthority('sys:user:delete')")
    public ResultVo deleteUser(@PathVariable Long userId) {
        return userService.deleteUser(userId);
    }

    /**
     * 获取用户信息
     *
     * @param userId
     * @return
     */
    @GetMapping("/getUserById/{userId}")
    @PreAuthorize("hasAuthority('sys:user:list')")
    public ResultVo getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    /**
     * 分配角色
     *
     * @param userParam
     * @return
     */
    @PostMapping("/assignRole")
    @PreAuthorize("hasAuthority('sys:user:assignRole')")
    public ResultVo assignRole(@RequestBody UserParam userParam) {
        return userService.assignRole(userParam);
    }

    /**
     * 重置密码
     *
     * @param userId
     * @return
     */
    @PostMapping("/resetPassword/{userId}")
    @PreAuthorize("hasAuthority('sys:user:resetPassword')")
    public ResultVo resetPassword(@PathVariable Long userId) {
        return userService.resetPassword(userId);
    }

    /**
     * 获取当前登录用户信息
     *
     * @return
     */
    @GetMapping("/getInfo")
    public ResultVo getInfo() {
        return userService.getInfo();
    }
}
