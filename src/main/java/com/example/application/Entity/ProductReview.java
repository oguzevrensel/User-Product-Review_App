package com.example.application.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "product_review")
@NoArgsConstructor
@Getter
@Setter
public class ProductReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(max = 500)
    @Column(name = "review")
    private String review;

    @Column(name = "review_date")
    private LocalDate reviewDate;

    @ManyToOne()
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne()
    @JoinColumn(name="product_id")
    private Product product;
}
