package com.duyhk.clothing_ecommerce.reponsitory;

import com.duyhk.clothing_ecommerce.entity.BillDetail;
import com.duyhk.clothing_ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductReponsitory extends JpaRepository<Product, Long> {
}
