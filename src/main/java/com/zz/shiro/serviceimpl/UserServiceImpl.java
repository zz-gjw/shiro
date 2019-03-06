package com.zz.shiro.serviceimpl;

import com.zz.shiro.common.util.ResultUtil;
import com.zz.shiro.common.vo.PageVo;
import com.zz.shiro.common.vo.ResultVo;
import com.zz.shiro.dao.SysUserMapper;
import com.zz.shiro.entity.SysUser;
import com.zz.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author : zz-gjw
 * @Date : 2019/3/5 16:46
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private SysUserMapper userMapper;

    @Override
    public ResultVo add(SysUser user, int rid) {
        userMapper.insert(user);
        return null;
    }

    @Override
    public PageVo<SysUser> querypage(int page, int limit) {
        return null;
    }

    @Override
    public ResultVo login(String name, String password) {
        SysUser user=userMapper.selectByName(name);
        if(user!=null){
            //Objects.equals(user.getPassword(),password);  jdk8 提供的工具类
            if(user.getPassword().equals(password)){
                return ResultUtil.exec(true,"ok",user);
            }
        }
        return ResultUtil.exec(false,"用户或者密码错误",null);
    }
}
