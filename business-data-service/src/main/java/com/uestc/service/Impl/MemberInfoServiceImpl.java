package com.uestc.service.Impl;

import com.uestc.common.ListResult;
import com.uestc.common.Result;
import com.uestc.common.StatEnum;
import com.uestc.dao.entity.MemberInfo;
import com.uestc.dao.mapper.MemberInfoMapper;
import com.uestc.model.MemberInfoData;
import com.uestc.service.MemberInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fucheng on 2019/7/15.
 */

@Service(value = "memberInfoService")
public class MemberInfoServiceImpl implements MemberInfoService {

    @Autowired
    private MemberInfoMapper memberInfoMapper;
    @Override
    public Result getMemberList() {
        List<MemberInfo> memberInfoList = memberInfoMapper.getMemberList();
        List<MemberInfoData> memberInfoDataList = new ArrayList<>();


        for(MemberInfo data : memberInfoList){
            MemberInfoData temp = new MemberInfoData();
            temp.setName(data.getMemberName());
            temp.setPosition(data.getPosition());
            temp.setViolation(data.getViolation());
            temp.setLocation(data.getLocation());
            memberInfoDataList.add(temp);
        }

        return new ListResult(StatEnum.SUCCESS.getState(),StatEnum.SUCCESS.getInfo(),memberInfoDataList.size(),memberInfoDataList);
    }
}
