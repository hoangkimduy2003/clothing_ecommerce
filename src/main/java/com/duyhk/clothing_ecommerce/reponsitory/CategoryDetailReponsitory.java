package com.duyhk.clothing_ecommerce.reponsitory;

import com.duyhk.clothing_ecommerce.entity.CategoryDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryDetailReponsitory extends JpaRepository<CategoryDetail, Long> {
    List<CategoryDetail> findByCategoryId(Long id);
}
