package com.shop.servicebase.handler;

import com.shop.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice     //异常
@Slf4j
public class ExceptionHandlers {

//    @ExceptionHandler(Exception.class)
//    @ResponseBody
//    public Result errorr(Exception e){
//        e.printStackTrace();
//        return Result.fail().message("异常");
//    }
//
//    @ExceptionHandler(ArithmeticException.class)
//    @ResponseBody
//    public Result errorr(ArithmeticException e){
//        e.printStackTrace();
//        return Result.fail().message("异常");
//    }

    @ExceptionHandler(MyException.class)
    @ResponseBody
    public Result errorr(MyException e){
//        log.error(e.getMessage());
        e.printStackTrace();
        return Result.fail().message(e.getMsg()).code(e.getCode());
    }
}
