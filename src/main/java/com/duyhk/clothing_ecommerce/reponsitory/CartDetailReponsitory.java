package com.duyhk.clothing_ecommerce.reponsitory;

import com.duyhk.clothing_ecommerce.entity.BillDetail;
import com.duyhk.clothing_ecommerce.entity.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartDetailReponsitory extends JpaRepository<CartDetail, Long> {
}
