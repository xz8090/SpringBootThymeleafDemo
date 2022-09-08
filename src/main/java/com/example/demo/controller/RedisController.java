package com.example.demo.controller;

import com.example.demo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RedisController {

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("redis")
    public void redisTest(){
        Boolean result = redisUtil.set("testRedis","我是测试数据");
        if(result == true){
            System.out.println("存入成功");
        }else {
            System.out.println("存入失败");
        }
    }
}
