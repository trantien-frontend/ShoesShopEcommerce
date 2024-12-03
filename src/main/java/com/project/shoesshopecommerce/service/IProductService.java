package com.project.shoesshopecommerce.service;

import com.project.shoesshopecommerce.dto.request.ProductRequest;
import com.project.shoesshopecommerce.dto.response.PageDTO;
import com.project.shoesshopecommerce.entity.Product;

import java.util.List;

public interface IProductService {
    public List<Product> findAllProducts();

     PageDTO<Product> findProductsByCategory(String category, ProductRequest productRequest);
}
