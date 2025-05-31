package com.manong.utils;

import com.manong.entity.Permission;
import com.manong.vo.PermissionVo;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 菜单树工具类
 */
public class MenuTree {

    /**
     * 构建菜单树
     * @param permissions 权限列表
     * @param pid 父级ID
     * @return 菜单树
     */
    public static List<PermissionVo> buildMenuTree(List<Permission> permissions, Long pid) {
        List<PermissionVo> tree = new ArrayList<>();
        Optional.ofNullable(permissions).orElse(new ArrayList<>()) // 处理permissions为null的情况
                .stream()
                .filter(item -> item.getParentId().equals(pid))
                .forEach(item -> {
                    PermissionVo vo = new PermissionVo();
                    BeanUtils.copyProperties(item, vo);
                    vo.setChildren(buildMenuTree(permissions, item.getId()));
                    tree.add(vo);
                });
        return tree;
    }
}