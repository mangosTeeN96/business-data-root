package com.uestc.service.Impl;


import com.uestc.common.*;
import com.uestc.dao.entity.User;
import com.uestc.dao.mapper.UserMapper;
import com.uestc.model.UserData;
import com.uestc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by fucheng on 2019/7/15.
 */

@Service(value = "userService")
public class UserServiceImpl implements UserService {
    //依赖注入
    @Autowired
    private UserMapper userMapper;

    public UserData getUserData(User entity){
        UserData data = new UserData();
        if(entity != null){
            data.setUserName(entity.getUserName());
            data.setUserPhone(entity.getUserPhone());
            data.setAddress(entity.getAddress());
            data.setAge(entity.getAge());
        }
        return data;
    }

    @Override
    public UserData getUserInfo(String name) {
        UserData userData = new UserData();
        User user = userMapper.selectUserByName(name);
        if(user!=null){
            userData.setUserId(user.getUserId());
            userData.setUserName(user.getUserName());
            userData.setAge(user.getAge());

        }
        return  userData;
    }

    //TODO 异常抛出还没出来
    @Override
    public Result getById(Integer id) throws Exception{
        User user = userMapper.getById(id);

        return new DataResult(StatEnum.SUCCESS.getState(),StatEnum.SUCCESS.getInfo(), FillUtil.fill(user,UserData.class));
    }

    @Override
    public  Result getUserInfo(Integer age, String address) throws Exception{
        Map<String,Object> map = new HashMap<>();
        map.put("age",age);
        map.put("address",address);
        List<User> userList = userMapper.getUserInfo(map);
        List<UserData> userDataList= new ArrayList<>();

//        if ( userList!= null){
//            userList.forEach((data)->userDataList.add(getUserData(data)));
//        }

        for(User userTemp:userList){
            UserData userData = new UserData();
            userData.setUserName(userTemp.getUserName());
            userData.setAge(userTemp.getAge());
            userData.setAddress(userTemp.getAddress());
            userData.setUserPhone(userTemp.getUserPhone());

            userDataList.add(userData);
        }


        return new ListResult(StatEnum.SUCCESS.getState(),StatEnum.SUCCESS.getInfo(),userDataList.size(),userDataList);
    }

    @Override
    public Result add(UserData userData) throws Exception {
        User user =  new User();
        if(userData!= null){
            user.setUserName(userData.getUserName());
            user.setAge(userData.getAge());
            user.setAddress(userData.getAddress());
            user.setUserPhone(userData.getUserPhone());
        }
        Integer num = userMapper.add(user);
        if(num != 1){
            return new Result(StatEnum.FAILED.getState(),StatEnum.SUCCESS.getInfo());
        }
        return new Result(StatEnum.SUCCESS.getState(),StatEnum.SUCCESS.getInfo());
    }

    @Override
    public Result batchAdd(List<UserData> userDataList) {
        List<User> userList = new ArrayList<>();
        for(UserData data :userDataList){
            User userTemp = new User();
            userTemp.setUserName(data.getUserName());
            userTemp.setAge(data.getAge());
            userTemp.setAddress(data.getAddress());
            userTemp.setUserPhone(data.getUserPhone());

            userList.add(userTemp);
        }

        Integer num = userMapper.batchAdd(userList);
        if(num != userList.size()){
            return new Result(StatEnum.FAILED.getState(),StatEnum.SUCCESS.getInfo());
        }
        return new Result(StatEnum.SUCCESS.getState(),StatEnum.SUCCESS.getInfo());
    }

    @Override
    public Result remove(Integer userId){
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userId);
        Integer num = userMapper.remove(map);
        if(num != 1){
            return new Result(StatEnum.FAILED.getState(),StatEnum.SUCCESS.getInfo());
        }
        return new Result(StatEnum.SUCCESS.getState(),StatEnum.SUCCESS.getInfo());
    }

    @Override
    public Result update(UserData userData){
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userData.getUserId());
        map.put("userName",userData.getUserName());
        map.put("userPhone",userData.getUserPhone());

        Integer num = userMapper.update(map);
        if(num != 1){
            return new Result(StatEnum.FAILED.getState(),StatEnum.SUCCESS.getInfo());
        }
        return new Result(StatEnum.SUCCESS.getState(),StatEnum.SUCCESS.getInfo());
    }
}
