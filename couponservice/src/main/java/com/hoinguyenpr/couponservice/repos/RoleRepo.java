package com.hoinguyenpr.couponservice.repos;

import com.hoinguyenpr.couponservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
}
