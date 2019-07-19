package com.uestc.service;

import com.uestc.common.Result;
import com.uestc.model.UserData;

import java.util.List;

/**
 * Created by fucheng on 2019/7/15.
 */
public interface UserService {

    UserData getUserInfo(String name);

    Result getById(Integer id) throws Exception;

    Result getUserInfo(Integer age, String address) throws Exception;

    Result add(UserData userData)throws Exception;

    Result batchAdd(List<UserData> userData);

    Result remove(Integer userId);

    Result update(UserData userData);
}
