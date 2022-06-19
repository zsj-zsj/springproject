package com.shop.eduservice.client;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.shop.utils.Result;
import org.springframework.stereotype.Component;

//熔断设置
@Component
public class HystrixFeignClient implements ServiceVideoClient{
    @Override
    public Result uploadAliyunVideo(String vid) {
        return Result.fail().data("msg","删除阿里云视频 time out");
    }
}
