package com.shop.eduservice.controller;


import com.shop.utils.Result;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/eduservice")
@CrossOrigin
public class EduLoginController {


    @PostMapping("/user/login")
    public Result login(){
        return Result.success().data("token","token666");
    }

    @GetMapping("/user/info")
    public Result info(){
        return Result.success().data("roles","[admin]").data("name","name").data("avatar","https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.jj20.com%2Fup%2Fallimg%2F1114%2F113020142315%2F201130142315-1-1200.jpg&refer=http%3A%2F%2Fimg.jj20.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1657766630&t=5673d1eddffaf35e21ff3b15bed82b0c");
    }
}

