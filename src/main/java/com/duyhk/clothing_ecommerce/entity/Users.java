package com.duyhk.clothing_ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;
    private String image;
    private String role;
    private Integer status;


    @OneToMany(mappedBy = "user")
    private List<Address> addresses;

    @OneToMany(mappedBy = "user")
    private List<ReviewProduct> reviewProducts;

    @OneToMany(mappedBy = "user")
    private List<Bill> bills;

    @OneToOne(cascade = CascadeType.ALL)
    private Cart cart;

    @OneToOne(cascade = CascadeType.ALL)
    private Favourite favourite;

}
