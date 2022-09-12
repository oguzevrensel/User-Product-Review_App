package com.example.application.Service;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.example.application.Entity.Product;
import com.example.application.Entity.ProductReview;
import com.example.application.Repository.ProductRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll(){
        return this.productRepository.findAll();
    }
    public List<Product> add(Product product){
        if(product.getName().isEmpty() || product.getName().isBlank()
                || product.getPrice()<=0)
            return null;
        this.productRepository.save(product);
        return null;
    }

    public List<Product> findByExpirationDate(@Param("expirationDate") LocalDate expirationDate){
        return this.productRepository.findByExpirationDateBeforeOrExpirationDateIsNull(expirationDate);
    }

    public List<Product> findByExpirationDateGreater(@Param("expirationDate") LocalDate expirationDate){
        return this.productRepository.findByExpirationDateGreaterThanEqual(expirationDate);
    }
}