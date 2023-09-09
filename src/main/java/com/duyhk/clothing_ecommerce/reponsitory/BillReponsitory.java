package com.duyhk.clothing_ecommerce.reponsitory;

import com.duyhk.clothing_ecommerce.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillReponsitory extends JpaRepository<Bill,Long> {
}
