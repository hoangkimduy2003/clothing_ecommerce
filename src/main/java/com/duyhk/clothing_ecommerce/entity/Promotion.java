package com.duyhk.clothing_ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Promotion extends TimeAuditable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double promotionalLevel;
    private Double maximumPromotion;
    private Date dateStart;
    private Date dateEnd;
    private Integer status;

    @OneToMany(mappedBy = "promotion", cascade = CascadeType.ALL)
    private List<PromotionDetail> promotionDetails;
}
