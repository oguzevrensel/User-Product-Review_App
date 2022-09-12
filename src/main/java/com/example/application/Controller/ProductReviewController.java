package com.example.application.Controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import com.example.application.Entity.Product;
import com.example.application.Entity.ProductReview;
import com.example.application.Entity.User;
import com.example.application.Service.ProductReviewService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/product-review")
public class ProductReviewController {

    private final ProductReviewService productReviewService;

    public ProductReviewController(ProductReviewService productReviewService) {
        this.productReviewService = productReviewService;
    }

    @PostMapping("/add")
    public List<ProductReview> add(@RequestBody ProductReview productReview){
        return this.productReviewService.add(productReview);
    }

    @GetMapping("/getAll")
    public List<ProductReview> getAll(){
        return this.productReviewService.findAll();
    }

    @GetMapping("/findByProduct")
    public List<ProductReview> findByProduct(int productId){
        return this.productReviewService.findByProduct(productId);
    }

    @GetMapping("/findByUser")
    public List<ProductReview> findByUser(int userId){
        return this.productReviewService.findByUser(userId);
    }

    @GetMapping("/findByUserAndDateBetween")
    public List<ProductReview> findByUserAndReviewDateBetween(int userId, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from){
        return this.productReviewService.findByUserAndReviewDateBetween(userId,to,from);
    }

    @GetMapping("/findByProductAndDateBetween")
    public List<ProductReview> findByProductAndReviewDateBetween(int productId, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from){
        return this.productReviewService.findByProductAndReviewDateBetween(productId,to,from);
    }
}