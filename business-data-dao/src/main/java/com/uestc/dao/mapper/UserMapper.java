package com.uestc.dao.mapper;


import com.uestc.dao.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by fucheng on 2019/7/15.
 */

public interface UserMapper {

    User selectUserByName(String name);

    User getById(@Param("userId") Integer userId);

    List<User> getUserInfo(Map<String, Object> map);

    Integer add(User user);

    Integer batchAdd(List<User> userList);

    Integer remove(Map<String, Object> map);

    Integer update(Map<String, Object> map);


}