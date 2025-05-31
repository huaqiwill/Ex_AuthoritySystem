package com.manong.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.manong.entity.Department;
import com.manong.param.DepartmentParam;
import com.manong.utils.ResultVo;

import java.util.List;

/**
 * 部门服务接口
 */
public interface DepartmentService extends IService<Department> {

    /**
     * 查询所有部门列表
     * @return 部门列表
     */
    ResultVo getDepartmentList(DepartmentParam departmentParam);

    /**
     * 新增部门
     * @param departmentParam
     * @return
     */
    ResultVo addDepartment(DepartmentParam departmentParam);

    /**
     * 编辑部门
     * @param departmentParam
     * @return
     */
    ResultVo editDepartment(DepartmentParam departmentParam);

    /**
     * 删除部门
     * @param departmentId
     * @return
     */
    ResultVo deleteDepartment(Long departmentId);

    /**
     * 获取上级部门
     * @return
     */
    ResultVo getParentDepartmentList();

    /**
     * 获取部门树
     * @return
     */
    ResultVo getDepartmentTree();
}
