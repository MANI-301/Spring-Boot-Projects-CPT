package com.app.repository;





import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entity.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE UPPER(p.name) LIKE UPPER(:name) ESCAPE '\\'")
    List<Product> findByNameContainingIgnoreCase(String name);
    List<Product> findByPriceGreaterThan(Double price);
}