package com.uestc.service.Impl;

import com.uestc.common.ListResult;
import com.uestc.common.Result;
import com.uestc.common.StatEnum;
import com.uestc.dao.entity.MemberInfo;
import com.uestc.dao.entity.TestTransheader;
import com.uestc.dao.mapper.MemberInfoMapper;
import com.uestc.dao.mapper.TestTransheaderMap;
import com.uestc.model.MemberInfoData;
import com.uestc.model.TestTransheaderData;
import com.uestc.service.TestTransheaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fucheng on 2019/7/17.
 */

@Service(value = "testTransheaderService")
public class TestTransheaderServiceImpl implements TestTransheaderService{
    @Autowired
    private TestTransheaderMap testTransheaderMap;
    @Override
    public Result getTransheaderList() {
        List<TestTransheader> testTransheaderList = testTransheaderMap.getTransheaderList();
        List<TestTransheaderData> testTransheaderDataList = new ArrayList<>();


        for(TestTransheader data : testTransheaderList){
            TestTransheaderData temp = new TestTransheaderData();
            temp.setCount(data.getCount());
            temp.setSumamt(data.getSumamt());
            temp.setDizdate(data.getDizdate());
            testTransheaderDataList.add(temp);
        }

        return new ListResult(StatEnum.SUCCESS.getState(),StatEnum.SUCCESS.getInfo(),testTransheaderDataList.size(),testTransheaderDataList);
    }
}
