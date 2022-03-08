package com.hoinguyenpr.couponservice.controller;

import com.hoinguyenpr.couponservice.model.Coupon;
import com.hoinguyenpr.couponservice.repos.CouponRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/couponapi")
public class CouponRestController {

    @Autowired
    CouponRepo repo;

    @PostMapping("/coupons")
    public Coupon createCoupon(@RequestBody Coupon coupon) {
        return repo.save(coupon);
    }

    @GetMapping("/coupons/{code}")
    public Coupon getCoupon(@PathVariable("code") String code) {
        return repo.findByCode(code);
    }

}
