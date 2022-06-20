package com.shop.cmsservice.controller;

import com.shop.cmsservice.entity.CrmBanner;
import com.shop.cmsservice.service.CrmBannerService;
import com.shop.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("banner")
public class BannerFrontController {

    @Autowired
    private CrmBannerService crmBannerService;

    @GetMapping("bannerList")
    public Result bannerList(){
        List<CrmBanner> crmBanners = crmBannerService.bannerList();
        return Result.success().data("data",crmBanners);
    }

}
