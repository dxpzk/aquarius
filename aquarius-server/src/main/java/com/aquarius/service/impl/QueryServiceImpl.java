package com.aquarius.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.aquarius.api.service.UserApi;
import com.aquarius.mapper.UserMapper;
import com.aquarius.service.QueryService;
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
