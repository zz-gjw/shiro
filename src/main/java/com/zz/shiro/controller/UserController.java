package com.zz.shiro.controller;

import com.zz.shiro.common.sysconst.SystemCon;
import com.zz.shiro.common.vo.ResultVo;
import com.zz.shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * @Author : zz-gjw
 * @Date : 2019/3/5 16:59
 * @Description:
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    //登录
    @PostMapping("userlogin.do")
    public ResultVo login(String name,String password){
        ResultVo resultVo=userService.login(name,password);
        if(resultVo.getCode()==SystemCon.OK){
            //1、创建登录令牌
            UsernamePasswordToken token=new UsernamePasswordToken(name,password);
            //2、获取主题
            Subject subject= SecurityUtils.getSubject();
            //3、在Session设置当前的登录用户
            subject.getSession().setAttribute("user",resultVo.getData());
            //4、发起认证 ---会调用Shiro对应的Realm的认证方法
            subject.login(token);
        }
        return resultVo;
    }
}
