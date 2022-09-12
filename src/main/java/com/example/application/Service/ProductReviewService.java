package com.example.application.Service;

import org.springframework.stereotype.Service;

import com.example.application.Entity.Product;
import com.example.application.Entity.ProductReview;
import com.example.application.Repository.ProductReviewRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductReviewService {

    private final ProductReviewRepository productReviewRepository;

    public ProductReviewService(ProductReviewRepository productReviewRepository) {
        this.productReviewRepository = productReviewRepository;
    }

    public List<ProductReview> findByProduct(int productId){
        return this.productReviewRepository.findByProductId(productId);
    }

    public List<ProductReview> findByUser(int userId){
        return this.productReviewRepository.findByUserId(userId);
    }

    public List<ProductReview> add(ProductReview productReview){
        if(productReview.getReview().isEmpty() || productReview.getReview().isBlank())
            return null;

        this.productReviewRepository.save(productReview);
        return null;
    }

    public List<ProductReview> findByUserAndReviewDateBetween(int userId, LocalDate to, LocalDate from){
        return this.productReviewRepository.findByUserIdAndReviewDateBetween(userId, to,from);
    }

    public List<ProductReview> findByProductAndReviewDateBetween(int productId, LocalDate to, LocalDate from){
        return this.productReviewRepository.findByProductIdAndReviewDateBetween(productId, to,from);
    }

    public List<ProductReview> findAll(){
        return this.productReviewRepository.findAll();
    }
}