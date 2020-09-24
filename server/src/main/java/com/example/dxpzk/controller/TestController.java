package com.example.dxpzk.controller;

import com.example.dxpzk.mq.producer.Producer;
import com.example.dxpzk.service.QueryService;
import com.example.dxpzk.utils.RedisUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @Autowired
    private QueryService queryService;

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private Producer producer;

    @ResponseBody
    @RequestMapping(value="/query", produces={"application/json;charset=UTF-8"})
    @Transactional(rollbackFor = Throwable.class, isolation = Isolation.DEFAULT, propagation = Propagation.MANDATORY)
    public void query(@RequestParam int num){

        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken("username", "password");
        subject.login(token);


        redisUtils.add("key",num);
        producer.producer();

        System.out.println(queryService.queryInfo(num));
        System.out.println(queryService.queryInfo(num));
    }
}
