//package com.project.shoesshopecommerce.service;
//
//import com.project.shoesshopecommerce.dto.request.ProductRequest;
//import com.project.shoesshopecommerce.entity.Product;
//import com.project.shoesshopecommerce.repository.IProductRepository;
//import com.project.shoesshopecommerce.service.impl.ProductService;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.PageRequest;
//
//import java.util.Date;
//import java.util.List;
//
//@ExtendWith(MockitoExtension.class)
//public class ProductServiceTest {
//    @Mock
//    private IProductRepository productRepository;
//
//    @InjectMocks
//    private ProductService productService;
//
//    private ProductRequest productRequest;
//
//    @BeforeEach
//    void setUp() {
//        productRequest = new ProductRequest();
//    }
//
//    @Test
//    void testFindProductsByCategory_Success() {
//        String category = "dress";
//        List<Product> mockProducts = List.of(
//            Product.builder().id(1).name("Tokin").price(1500000.00).discount(50).promoPrice(1200000.00).createdAt(new Date()).updatedAt(new Date()).build()
//        );
//        Page<Product> mockPage = new PageImpl<>(mockProducts);
//
//       Mockito.when(productRepository.findProductsByCategory(category, PageRequest.of(productRequest.getPage(), productRequest.getLimit()))).thenReturn(mockPage);
//       Assertions.assertNotNull(mockPage);
//       Mockito.verify(productRepository, Mockito.times(1)).findProductsByCategory(category, PageRequest.of(productRequest.getPage(), productRequest.getLimit()));
//    }
//}
