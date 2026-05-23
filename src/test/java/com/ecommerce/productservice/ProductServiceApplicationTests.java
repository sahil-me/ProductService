package com.ecommerce.productservice;

import com.ecommerce.productservice.projections.ProductWithIdAndTitle;
import com.ecommerce.productservice.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProductServiceApplicationTests {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testDbQueries(){
        List<ProductWithIdAndTitle> productsWithIdAndTitle =
                productRepository.randomSearchMethodForProduct();

        for (ProductWithIdAndTitle product: productsWithIdAndTitle) {
            System.out.println(product.getId() + " " + product.getTitle());
        }

        List<ProductWithIdAndTitle> productsWithIdAndTitleFromNative =
                productRepository.nativeSearchMethodForProduct();

        for (ProductWithIdAndTitle product: productsWithIdAndTitleFromNative) {
            System.out.println(product.getId() + " " + product.getTitle());
        }

        System.out.println("DEBUG");
    }

}
