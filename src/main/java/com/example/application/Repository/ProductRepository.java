package com.example.application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.application.Entity.Product;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    //    List<Product> findByExpirationDate(Product product);
    List<Product> findByExpirationDateBeforeOrExpirationDateIsNull(@Param("expirationDate") LocalDate expirationDate);
    List<Product> findByExpirationDateGreaterThanEqual(@Param("expirationDate") LocalDate expirationDate);

}
