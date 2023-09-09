package com.duyhk.clothing_ecommerce.reponsitory;

import com.duyhk.clothing_ecommerce.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReponsitory extends JpaRepository<Users,Long> {
}
