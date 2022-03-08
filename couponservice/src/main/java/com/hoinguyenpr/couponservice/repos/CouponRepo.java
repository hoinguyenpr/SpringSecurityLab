package com.hoinguyenpr.couponservice.repos;

import com.hoinguyenpr.couponservice.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepo extends JpaRepository<Coupon, Long> {
    Coupon findByCode(String code);
}
