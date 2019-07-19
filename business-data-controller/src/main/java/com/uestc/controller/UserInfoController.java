package com.uestc.controller;

import com.uestc.common.Result;
import com.uestc.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by fucheng on 2019/7/15.
 */

@Controller
@RequestMapping(value = "api")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "login",method = RequestMethod.GET)
    @ResponseBody
    public Result login(String account, String password){

        return userInfoService.login(account,password);
    }

    @RequestMapping(value = "user/list",method = RequestMethod.GET)
    @ResponseBody
    public Result getMemberList(){

        return userInfoService.getUserList();
    }
}
