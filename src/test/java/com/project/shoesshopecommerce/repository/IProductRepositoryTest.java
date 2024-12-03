package com.project.shoesshopecommerce.repository;

import com.project.shoesshopecommerce.entity.Category;
import com.project.shoesshopecommerce.entity.Product;
import com.project.shoesshopecommerce.entity.ProductType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class IProductRepositoryTest {
    @Autowired
    IProductRepository underProductRepository;

    @Test
    void shouldReturnPageOfProductWhenFindProductsByCategory() {

        Category category = new Category(1, "Dress");
        Product product = new Product();
        product.setId(1);
        product.setName("TONKIN CAPTOE OXFORD - OF07");
        product.setPrice(1500000);
        product.setDiscount(50);
        product.setPromoPrice(1200000);
        product.setCategory(category);
        product.setProductType(new ProductType(1, "oxford"));
        product.setCreatedAt(new Date());
        product.setUpdatedAt(new Date());

        Pageable pageable = PageRequest.of(0, 1);

        Page<Product> result = underProductRepository.findProductsByCategory(category.getCategory(), pageable);
        assertThat(result).isNotNull();
    }
}