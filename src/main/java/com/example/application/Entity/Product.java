package com.example.application.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name = "product")
@NoArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<ProductReview> productReviews;
}
