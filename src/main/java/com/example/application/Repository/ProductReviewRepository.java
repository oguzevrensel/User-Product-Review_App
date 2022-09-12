package com.example.application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.application.Entity.Product;
import com.example.application.Entity.ProductReview;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductReviewRepository extends JpaRepository<ProductReview, Integer> {

    List<ProductReview> findByUserId(int userId);
    List<ProductReview> findByProductId(int productId);

    List<ProductReview> findByUserIdAndReviewDateBetween(int userId, LocalDate to, LocalDate from);
    List<ProductReview> findByProductIdAndReviewDateBetween(int productId, LocalDate to, LocalDate from);



}
