package com.hoinguyenpr.couponservice.repos;

import com.hoinguyenpr.couponservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
