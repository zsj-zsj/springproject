package com.shop.eduservice.client;


import com.shop.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-video", fallback = HystrixFeignClient.class)
@Component
public interface ServiceVideoClient {

    //PathVariable("vid") 一定要指定参数名称
    @DeleteMapping("/eduservice/eduvideo/deleteAliyunVideo/{vid}")
    Result uploadAliyunVideo(@PathVariable("vid") String vid);


}
