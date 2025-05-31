package com.manong.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manong.entity.Department;
import com.manong.param.DepartmentParam;
import com.manong.service.DepartmentService;
import com.manong.utils.ResultVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {

    @Override
    public ResultVo getDepartmentList(DepartmentParam departmentParam) {
        QueryWrapper<Department> queryWrapper = new QueryWrapper<>();
        Optional.ofNullable(departmentParam.getDepartmentName())
                .ifPresent(name -> queryWrapper.like("departmentName", name));
        Optional.ofNullable(departmentParam.getDepartmentCode())
                .ifPresent(code -> queryWrapper.like("departmentCode", code));
        queryWrapper.orderByAsc("orderNum");
        List<Department> departments = baseMapper.selectList(queryWrapper);
        return ResultVo.success("查询成功", departments);
    }

    @Override
    public ResultVo addDepartment(DepartmentParam departmentParam) {
        Department department = new Department();
        BeanUtils.copyProperties(departmentParam, department);
        department.setCreateTime(new Date());
        int insert = baseMapper.insert(department);
        if (insert > 0) {
            return ResultVo.success("新增成功");
        }
        return ResultVo.fail("新增失败");
    }

    @Override
    public ResultVo editDepartment(DepartmentParam departmentParam) {
        Department department = new Department();
        BeanUtils.copyProperties(departmentParam, department);
        int update = baseMapper.updateById(department);
        if (update > 0) {
            return ResultVo.success("修改成功");
        }
        return ResultVo.fail("修改失败");
    }

    @Override
    public ResultVo deleteDepartment(Long departmentId) {
        // 判断部门下是否有子部门
        QueryWrapper<Department> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parentId", departmentId);
        if (baseMapper.selectCount(queryWrapper) > 0) {
            return ResultVo.fail("该部门下有子部门，不能删除");
        }
        int delete = baseMapper.deleteById(departmentId);
        if (delete > 0) {
            return ResultVo.success("删除成功");
        }
        return ResultVo.fail("删除失败");
    }

    @Override
    public ResultVo getParentDepartmentList() {
        QueryWrapper<Department> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parentId", 0);
        List<Department> departments = baseMapper.selectList(queryWrapper);
        return ResultVo.success("查询成功", departments);
    }

    @Override
    public ResultVo getDepartmentTree() {
        List<Department> departments = baseMapper.selectList(null);
        return ResultVo.success("查询成功", departments);
    }

    @Override
    public boolean save(Department entity) {
        return super.save(entity);
    }
}
