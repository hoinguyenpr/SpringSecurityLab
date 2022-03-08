package com.hoinguyenpr.productservice.controller;

import com.hoinguyenpr.productservice.dto.Coupon;
import com.hoinguyenpr.productservice.model.Product;
import com.hoinguyenpr.productservice.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/productapi")
public class ProductRequestController {

    @Autowired
    private ProductRepo repo;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${couponService.url}")
    private String couponServieURL;

    @PostMapping("/products")
    public Product create(@RequestBody Product product) {
        Coupon coupon = restTemplate.getForObject(couponServieURL + product.getCouponCode(), Coupon.class);
        product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
        return repo.save(product);
    }
}
