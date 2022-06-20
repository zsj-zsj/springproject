package com.shop.cmsservice.service;

import com.shop.cmsservice.entity.CrmBanner;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 首页banner表 服务类
 * </p>
 *
 * @author ZSJ
 * @since 2022-06-20
 */
public interface CrmBannerService extends IService<CrmBanner> {

    List<CrmBanner> bannerList();
}
