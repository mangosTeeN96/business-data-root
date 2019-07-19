package com.uestc.service.Impl;

import com.uestc.common.ListResult;
import com.uestc.common.Result;
import com.uestc.common.StatEnum;
import com.uestc.dao.entity.UserInfo;
import com.uestc.dao.mapper.UserInfoMapper;
import com.uestc.model.UserInfoData;
import com.uestc.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fucheng on 2019/7/15.
 */

@Service(value = "userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;


    @Override
    public Result login(String account,String password) {

        String oldPassword = userInfoMapper.getPassword(account);
        if(oldPassword != null){
            if(oldPassword.equals(password)){
                return new Result(StatEnum.LOGIN_SUCCESS.getState(),StatEnum.LOGIN_SUCCESS.getInfo());
            }

            return new Result(StatEnum.PASSWORD_ERROR.getState(),StatEnum.PASSWORD_ERROR.getInfo());
        }
        return new Result(StatEnum.FAILED.getState(),StatEnum.FAILED.getInfo());
    }

    @Override
    public Result getUserList() {
        List<UserInfo> userInfoList = userInfoMapper.getUserList();
        List<UserInfoData> userInfoDataList = new ArrayList<>();


        for(UserInfo data : userInfoList){
            UserInfoData temp = new UserInfoData();
            temp.setUserName(data.getUserName());
            temp.setAccount(data.getAccount());
            temp.setPosition(data.getPosition());
            temp.setUserPhone(data.getUserPhone());
            temp.setUserRight(data.getUserRight());
            userInfoDataList.add(temp);
        }

        return new ListResult(StatEnum.SUCCESS.getState(),StatEnum.SUCCESS.getInfo(),userInfoDataList.size(),userInfoDataList);
    }
}
