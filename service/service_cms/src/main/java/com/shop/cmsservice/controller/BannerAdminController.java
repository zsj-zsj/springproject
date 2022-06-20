package com.shop.cmsservice.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shop.cmsservice.dto.FunctionParam;
import com.shop.cmsservice.entity.CrmBanner;
import com.shop.cmsservice.service.CrmBannerService;
import com.shop.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 首页banner表 前端控制器
 * </p>
 *
 * @author ZSJ
 * @since 2022-06-20
 */
@RestController
@RequestMapping("/cmsservice/bannerAdmin")
public class BannerAdminController {

    @Autowired
    private CrmBannerService crmBannerService;

    @GetMapping("bannerList")
    public Result bannerList(FunctionParam functionParam){
        Page<CrmBanner> crmBannerPage = new Page<>(functionParam.getCurrentPage(),functionParam.getCurrentLimit());
        crmBannerService.page(crmBannerPage);
        List<CrmBanner> records = crmBannerPage.getRecords();
        return Result.success().data("data",records);
    }

    @PostMapping("bannerAdd")
    public Result bannerAdd(@RequestBody CrmBanner crmBanner){
        return Result.success().data("data",crmBannerService.save(crmBanner));
    }

    @DeleteMapping("bannerDelete/{id}")
    public Result bannerDelete(@PathVariable Integer id){
        return Result.success().data("data",crmBannerService.removeById(id));
    }

    @PutMapping("banneredit/{id}")
    public Result banneredit(@PathVariable Integer id, @RequestBody CrmBanner crmBanner){
        crmBanner.setId(id);
        return Result.success().data("data",crmBannerService.updateById(crmBanner));
    }

}

