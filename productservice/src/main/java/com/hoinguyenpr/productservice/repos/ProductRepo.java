package com.hoinguyenpr.productservice.repos;

import com.hoinguyenpr.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
