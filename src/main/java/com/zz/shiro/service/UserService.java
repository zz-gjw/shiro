package com.zz.shiro.service;

import com.zz.shiro.common.vo.PageVo;
import com.zz.shiro.common.vo.ResultVo;
import com.zz.shiro.entity.SysUser;

/**
 * @Author : zz-gjw
 * @Date : 2019/3/5 16:42
 * @Description:
 */
public interface UserService {
    //新增
    ResultVo add(SysUser user, int rid);
    //查询分页
    PageVo<SysUser> querypage(int page,int limit);
    //登录
    ResultVo login(String name,String password);
}
