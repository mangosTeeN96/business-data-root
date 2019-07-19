package com.uestc.controller;



import com.uestc.common.Result;
import com.uestc.model.UserData;
import com.uestc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by fucheng on 2019/7/15.
 */

//@RestController
@Controller
@RequestMapping(value = "/api")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "user",method = RequestMethod.GET)
    @ResponseBody
    public UserData selectUserByName() {

        return userService.getUserInfo("小明");
    }


    @RequestMapping(value = "get/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Result getById(@PathVariable Integer id)throws Exception{
        return  userService.getById(id);
    }

    /**
     * 根据条件查询
     * @param age
     * @param address
     * @return list<UserData>
     * @throws Exception
     * 接口格式：http://localhost:8035/api/info?age=20&address=北京
     */
    @RequestMapping(value = "info",method = RequestMethod.GET)
    @ResponseBody
    public Result getUserInfo(Integer age,String address)throws Exception{
        return  userService.getUserInfo(age,address);
    }


    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public  Result add(@RequestBody UserData userData)throws  Exception{
        return userService.add(userData);
    }


    @RequestMapping(value = "batchAdd",method = RequestMethod.POST)
    @ResponseBody
    public  Result batchAdd(@RequestBody List<UserData> userDataList)throws  Exception{
        return userService.batchAdd(userDataList);
    }

    @RequestMapping(value = "remove/{userId}",method = RequestMethod.GET)
    @ResponseBody
    public Result remove(@PathVariable Integer userId){
        return userService.remove(userId);
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    @ResponseBody
    public  Result update(@RequestBody UserData userData){
        return userService.update(userData);
    }



}