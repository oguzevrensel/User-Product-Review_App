package com.example.application.Controller;

import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import com.example.application.Entity.Product;
import com.example.application.Entity.ProductReview;
import com.example.application.Entity.User;
import com.example.application.Service.ProductService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/add")
    public List<Product> add(@RequestBody Product product){
        return this.productService.add(product);
    }

    @GetMapping("/getAll")
    public List<Product> getAll(){
        return this.productService.findAll();
    }

    @GetMapping("/findByDate")
    public List<Product> findByDate(@Param("expirationDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate expirationDate){
        return this.productService.findByExpirationDate(expirationDate);
    }

    @GetMapping("/findByDateGreater")
    public List<Product> findByDateGreater(@Param("expirationDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate expirationDate){
        return this.productService.findByExpirationDateGreater(expirationDate);
    }
}