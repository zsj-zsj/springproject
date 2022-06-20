package com.shop.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shop.servicebase.handler.ExceptionHandlers;
import com.shop.servicebase.handler.MyException;
import com.shop.user.entity.UcenterMember;
import com.shop.user.mapper.UcenterMemberMapper;
import com.shop.user.service.UcenterMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shop.user.vo.RegVO;
import com.shop.utils.JwtUtils;
import com.shop.utils.MD5;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author ZSJ
 * @since 2022-06-20
 */
@Service
public class UcenterMemberServiceImpl extends ServiceImpl<UcenterMemberMapper, UcenterMember> implements UcenterMemberService {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public String login(UcenterMember ucenterMember) {
        String mobile = ucenterMember.getMobile();
        String password = ucenterMember.getPassword();
        QueryWrapper<UcenterMember> wrapper = new QueryWrapper<>();
        wrapper.eq("mobile",mobile);
        wrapper.eq("password", MD5.encrypt(password));
        UcenterMember res = baseMapper.selectOne(wrapper);
        String jwtToken = "";
        if(res != null){
           jwtToken = JwtUtils.getJwtToken(res.getId(), res.getNickname());
        }
        return jwtToken;
    }

    @Override
    public int reg(RegVO regVO) {
        String code = redisTemplate.opsForValue().get(regVO.getMobile());
        if(!code.equals(regVO.getCode())){
            throw new MyException(50001,"验证码无效");
        }

        QueryWrapper<UcenterMember> wrapper = new QueryWrapper<>();
        wrapper.eq("mobile",regVO.getMobile());
        Integer integer = baseMapper.selectCount(wrapper);
        if(integer > 0){
            throw new MyException(50001,"手机号已注册");
        }
        regVO.setPassword(MD5.encrypt(regVO.getPassword()));
        UcenterMember ucenterMember = new UcenterMember();
        BeanUtils.copyProperties(regVO,ucenterMember);
        int insert = baseMapper.insert(ucenterMember);
        return insert;
    }
}
