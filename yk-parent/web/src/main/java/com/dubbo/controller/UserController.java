package com.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dubbo.pojo.User;
import com.dubbo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Reference
    private UserService userService;

    //登陆 判断状态值为1跳入订单列表  为2  跳入  商品列表
    @RequestMapping("/login")
    public String login(String username){
        User user = userService.selectUser(username);
        if (user.getState()==0){
            return "redirect:html/list.html";
        }
        if (user.getState()==1){
            return "redirect:html/slist.html";
        }
        return null;
    }

}
