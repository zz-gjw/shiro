package com.zz.shiro.dao;

import com.zz.shiro.entity.SysUser;
import org.apache.ibatis.annotations.Param;

public interface SysUserMapper {

    //注册
    int insert(SysUser record);

    SysUser selectById(Integer id);

    //判断该用户是否存在
    SysUser selectByName(String name);

    int updateByIdSelective(SysUser record);

    //根据id修改状态
    int updateByIdFlag(@Param("id") int id , @Param("flag")int flag);

    //修改密码
    int updateByIdPassword(@Param("id") int id , @Param("password")String password);
}