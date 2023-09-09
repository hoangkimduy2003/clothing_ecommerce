package com.duyhk.clothing_ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ReviewProduct extends TimeAuditable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double rating;

    private String description;

    @ManyToOne
    @JsonIgnoreProperties("reviewProducts")
    private ProductDetail productDetail;

    @ManyToOne
    @JsonIgnoreProperties("reviewProducts")
    private Users user;
}
