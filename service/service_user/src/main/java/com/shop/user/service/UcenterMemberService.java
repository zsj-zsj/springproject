package com.shop.user.service;

import com.shop.user.entity.UcenterMember;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shop.user.vo.RegVO;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author ZSJ
 * @since 2022-06-20
 */
public interface UcenterMemberService extends IService<UcenterMember> {

    String login(UcenterMember ucenterMember);

    int reg(RegVO regVO);
}
