package com.zz.shiro.dao;

import com.zz.shiro.entity.SysRolePerm;

public interface SysRolePermMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysRolePerm record);

    int insertSelective(SysRolePerm record);

    SysRolePerm selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRolePerm record);

    int updateByPrimaryKey(SysRolePerm record);
}