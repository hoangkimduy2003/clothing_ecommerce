package com.duyhk.clothing_ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product extends TimeAuditable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double importPrice;
    private Double price;
    private Double priceSale;
    private Long totalQuantitySold;
    private Long totalQuantity;
    private String description;
    private Long status;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> images;

    @ManyToOne
    @JsonIgnoreProperties("products")
    private CategoryDetail categoryDetail;

    @OneToMany(mappedBy = "product")
    private List<PromotionDetail> promotionDetails;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<ProductDetail> productDetails;

}
