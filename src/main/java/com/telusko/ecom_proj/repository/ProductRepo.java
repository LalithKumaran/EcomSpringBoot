package com.telusko.ecom_proj.repository;

import com.telusko.ecom_proj.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {
    public List<Product> findByBrand(String brand);

    @Query("SELECT p from Product p WHERE "+"LOWER(p.name) LIKE LOWER(CONCAT('%',:keyword,'%'))")
    List<Product> searchProducts(String keyword);

}
