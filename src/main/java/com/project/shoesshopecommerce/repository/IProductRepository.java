package com.project.shoesshopecommerce.repository;

import com.project.shoesshopecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    @Query("Select p from Product as p where p.category.category = :category")
    Page<Product> findProductsByCategory(@Param("category") String category, Pageable pageable);
}
