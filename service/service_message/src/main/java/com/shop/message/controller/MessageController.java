package com.shop.message.controller;

import com.shop.message.service.MessageService;
import com.shop.utils.RandomUtil;
import com.shop.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("aliyun/message")
public class MessageController {

    @Autowired
    private MessageService messageService;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @GetMapping("sendMessage/{mobile}")
    public Result sendMessage(@PathVariable String mobile){

        String code = redisTemplate.opsForValue().get(mobile);
        if(!StringUtils.isEmpty(code)){
            return Result.success().data("data",code);
        }
        code = RandomUtil.getSixBitRandom();
        Map<String, Object> map = new HashMap<>();
        map.put("code",code);
        Boolean res = messageService.sendMessage(map,mobile);
        if(res){
            redisTemplate.opsForValue().set(mobile,code,300, TimeUnit.SECONDS);
            return Result.success().data("data",res);
        }else{
            return Result.fail().data("data",res);
        }
    }

}
