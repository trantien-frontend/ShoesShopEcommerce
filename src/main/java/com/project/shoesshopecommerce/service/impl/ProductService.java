package com.project.shoesshopecommerce.service.impl;

import com.project.shoesshopecommerce.dto.request.ProductRequest;
import com.project.shoesshopecommerce.dto.response.PageDTO;
import com.project.shoesshopecommerce.entity.Product;
import com.project.shoesshopecommerce.exception.AppException;
import com.project.shoesshopecommerce.exception.ErrorCode;
import com.project.shoesshopecommerce.repository.IProductRepository;
import com.project.shoesshopecommerce.service.IProductService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ProductService implements IProductService {
    IProductRepository productRepository;

    @Override
    public List<Product> findAllProducts () {
        return productRepository.findAll();
    }

    @Transactional(rollbackOn = {Exception.class, Throwable.class})
    @Override
    public PageDTO<Product> findProductsByCategory(String category, ProductRequest productRequest) {
        try {
            log.info("Start method findProductsByCategory of service");
            Page<Product> products = productRepository.findProductsByCategory(category, PageRequest.of(productRequest.getPage(), productRequest.getLimit()));
            log.info("Excuted method findProductsByCategory of service success");
            return new PageDTO<>(products);
        } catch (DataAccessException dataAccessException) {
            log.error("DatabaseException: ", dataAccessException);
            throw new AppException(ErrorCode.UNCATEGORIZED_EXCEPTION);
        } catch (Exception exception) {
            log.error("Others exception: ", exception);
            throw new AppException(ErrorCode.UNCATEGORIZED_EXCEPTION);
        }
    }
}

