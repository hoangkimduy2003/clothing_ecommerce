package com.duyhk.clothing_ecommerce.reponsitory;

import com.duyhk.clothing_ecommerce.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserReponsitory extends JpaRepository<Users, Long> {
    @Query("select u from Users u where u.email = :email")
    Optional<Users> findByEmail(@Param("email") String email);
}
