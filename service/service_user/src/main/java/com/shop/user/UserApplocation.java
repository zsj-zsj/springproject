package com.shop.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.shop"})
@MapperScan("com.shop.user.mapper")
public class UserApplocation {

    public static void main(String[] args) {
        SpringApplication.run(UserApplocation.class,args);
    }

}
