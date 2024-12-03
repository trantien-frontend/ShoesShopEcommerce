package com.project.shoesshopecommerce.controller;

import com.project.shoesshopecommerce.dto.request.ProductRequest;
import com.project.shoesshopecommerce.dto.response.ApiResponse;
import com.project.shoesshopecommerce.dto.response.PageDTO;
import com.project.shoesshopecommerce.entity.Product;
import com.project.shoesshopecommerce.exception.AppException;
import com.project.shoesshopecommerce.exception.ErrorCode;
import com.project.shoesshopecommerce.service.IProductService;
import com.project.shoesshopecommerce.utils.ResponseUtil;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/products")
public class ProductController {
    IProductService productService;

    @GetMapping
    public List<Product> getProducts() {
        return productService.findAllProducts();
    }

    @PostMapping(path = "/category/{category}")
    public ResponseEntity<ApiResponse<PageDTO>> findProductsByCategory(@PathVariable(name = "category") String category, @RequestBody ProductRequest productRequest) {
        log.info("Start method findProductByCategory of ProductController");

        Optional.ofNullable(productRequest).orElseThrow(() -> {
            log.error("ProductRequest Parameter of method findProductByCateogry is null");
            throw new AppException(ErrorCode.MISSING_REQUEST_BODY);
        });

        Optional.ofNullable(category).orElseThrow(() -> {
            log.error("category Parameter of method findProductByCateogry is null");
            throw new AppException(ErrorCode.MISSING_REQUEST_BODY);
        });

        PageDTO<Product> page = productService.findProductsByCategory(category, productRequest);
        return ResponseUtil.responseSuccess(page);
    }
}
