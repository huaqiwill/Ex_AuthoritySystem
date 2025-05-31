package com.manong.controller;

import com.manong.param.DepartmentParam;
import com.manong.service.DepartmentService;
import com.manong.utils.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * 部门控制器
 */
@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    /**
     * 获取部门列表
     * @param departmentParam
     * @return
     */
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('sys:department:list')")
    public ResultVo getDepartmentList(DepartmentParam departmentParam) {
        return departmentService.getDepartmentList(departmentParam);
    }

    /**
     * 新增部门
     * @param departmentParam
     * @return
     */
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('sys:department:add')")
    public ResultVo addDepartment(@RequestBody DepartmentParam departmentParam) {
        return departmentService.addDepartment(departmentParam);
    }

    /**
     * 编辑部门
     * @param departmentParam
     * @return
     */
    @PutMapping("/edit")
    @PreAuthorize("hasAuthority('sys:department:edit')")
    public ResultVo editDepartment(@RequestBody DepartmentParam departmentParam) {
        return departmentService.editDepartment(departmentParam);
    }

    /**
     * 删除部门
     * @param departmentId
     * @return
     */
    @DeleteMapping("/delete/{departmentId}")
    @PreAuthorize("hasAuthority('sys:department:delete')")
    public ResultVo deleteDepartment(@PathVariable Long departmentId) {
        return departmentService.deleteDepartment(departmentId);
    }

    /**
     * 获取上级部门
     * @return
     */
    @GetMapping("/parent")
    @PreAuthorize("hasAuthority('sys:department:list')")
    public ResultVo getParentDepartmentList() {
        return departmentService.getParentDepartmentList();
    }

    /**
     * 获取部门树
     * @return
     */
    @GetMapping("/getDepartmentList")
    public ResultVo getDepartmentList() {
        DepartmentParam departmentParam = new DepartmentParam();
        return departmentService.getDepartmentList(departmentParam);
    }
}
