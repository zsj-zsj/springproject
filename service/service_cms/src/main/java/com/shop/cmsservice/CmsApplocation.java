package com.shop.cmsservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.shop"})
@MapperScan("com.shop.cmsservice.mapper")
public class CmsApplocation {

    public static void main(String[] args) {
        SpringApplication.run(CmsApplocation.class,args);
    }

}
