package com.fbw.gulimall.member.feign;

import com.fbw.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Sirloin
 * @Date 2021-02-2021/2/4-15:28
 */
//调用远程服务
@FeignClient("gulimall-coupon")
public interface CouponFeignService {
    //远程服务的方法，mapping里的地址要写全
    @RequestMapping("/coupon/coupon/member/list")
    public R membercoupons();
}
