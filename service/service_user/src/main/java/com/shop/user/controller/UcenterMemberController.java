package com.shop.user.controller;


import com.shop.user.entity.UcenterMember;
import com.shop.user.service.UcenterMemberService;
import com.shop.user.vo.RegVO;
import com.shop.utils.JwtUtils;
import com.shop.utils.MD5;
import com.shop.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/user/ucenterMember")
@CrossOrigin
public class UcenterMemberController {

    @Autowired
    private UcenterMemberService ucenterMemberService;

    @PostMapping("login")
    public Result login(@RequestBody UcenterMember ucenterMember){
        String token = ucenterMemberService.login(ucenterMember);
        return Result.success().data("data",token);
    }

    @PostMapping("reg")
    public Result reg(@RequestBody RegVO regVO){
        int res = ucenterMemberService.reg(regVO);
        return Result.success().data("data",res);
    }

    @GetMapping("userInfo")
    public Result userInfo(HttpServletRequest request){
        String jwtToken = request.getHeader("token");
        System.out.println(jwtToken);
        Integer memberIdByJwtToken = Integer.valueOf(JwtUtils.getMemberIdByJwtToken(request));
        return Result.success().data("data",memberIdByJwtToken);
    }

}

