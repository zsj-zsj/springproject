package com.shop.message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.shop"})
public class MessageApplocation {

    public static void main(String[] args) {
        SpringApplication.run(MessageApplocation.class,args);
    }

}
