package com.example.dxpzk.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.dxpzk.api.service.UserApi;
import com.example.dxpzk.mapper.UserMapper;
import com.example.dxpzk.model.UserModel;
import com.example.dxpzk.service.QueryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class QueryServiceImpl implements QueryService {

    @Resource
    private UserMapper userMapper;
    @Reference
    private UserApi userApi;

    public String queryInfo(int id){
        System.out.println(userApi.query());
//        PageHelper.startPage(1,1);
        return userMapper.query(id).toString();
    }
}
