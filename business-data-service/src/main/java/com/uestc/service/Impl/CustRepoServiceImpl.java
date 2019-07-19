package com.uestc.service.Impl;

import com.uestc.common.ListResult;
import com.uestc.common.Result;
import com.uestc.common.StatEnum;
import com.uestc.dao.entity.CustRepo;
import com.uestc.dao.mapper.CustRepoMap;
import com.uestc.model.CustRepoData;
import com.uestc.service.CustRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "CustRepoService")
public class CustRepoServiceImpl implements CustRepoService {
    @Autowired
    private CustRepoMap custRepoMap;

    @Override
    public Result getCustRepoList() {
        List<CustRepo> custRepoList = custRepoMap.getCustRepoList();
        List<CustRepoData> custRepoDataList = new ArrayList<>();


        for(CustRepo data : custRepoList){
            CustRepoData temp = new CustRepoData();
            temp.setBillmouth(data.getBillmouth());
            temp.setNum_amt(data.getNum_amt());
            temp.setNum_repo(data.getNum_repo());
            temp.setRepo_rate(data.getRepo_rate());
            custRepoDataList.add(temp);
        }

        return new ListResult(StatEnum.SUCCESS.getState(),StatEnum.SUCCESS.getInfo(),custRepoDataList.size(),custRepoDataList);
    }
}
