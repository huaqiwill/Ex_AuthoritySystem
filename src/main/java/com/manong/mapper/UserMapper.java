package com.manong.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.manong.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户数据访问层
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
    
    /**
     * 根据用户ID查询用户权限列表
     * @param userId 用户ID
     * @return 权限列表
     */
    List<String> findPermissionsByUserId(@Param("userId") Long userId);
    
    /**
     * 根据用户ID查询用户角色列表
     * @param userId 用户ID
     * @return 角色列表
     */
    List<String> findRolesByUserId(@Param("userId") Long userId);
}