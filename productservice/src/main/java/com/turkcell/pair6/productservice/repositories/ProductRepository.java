package com.turkcell.pair6.productservice.repositories;

import com.turkcell.pair6.productservice.entities.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Page<Product> findAllByIsActiveTrue(Pageable pageable);


    Optional<Product> findByIdAndIsActiveTrue(int productId);

    @Query("SELECT p FROM Product p WHERE p.productNo = :productNo AND p.isActive = true")
    Optional<Product> findActiveByProductNo(@Param("productNo") String productNo);

    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.isActive = false, p.deletedDate = CURRENT_TIMESTAMP WHERE p.id = :productNo")
    void deactivateByProductNo(@Param("productNo") int productNo);
}
