package com.ecommerce.productservice;

import com.ecommerce.productservice.models.Category;
import com.ecommerce.productservice.models.Product;
import com.ecommerce.productservice.projections.ProductWithIdAndTitle;
import com.ecommerce.productservice.repositories.CategoryRepository;
import com.ecommerce.productservice.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProductServiceApplicationTests {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void contextLoads() {
    }

    @Test
    @Transactional
    void testDbQueries(){

//        List<ProductWithIdAndTitle> productsWithIdAndTitle =
//                productRepository.randomSearchMethodForProduct();
//
//        for (ProductWithIdAndTitle product: productsWithIdAndTitle) {
//            System.out.println(product.getId() + " " + product.getTitle());
//        }
//
//        List<ProductWithIdAndTitle> productsWithIdAndTitleFromNative =
//                productRepository.nativeSearchMethodForProduct();
//
//        for (ProductWithIdAndTitle product: productsWithIdAndTitleFromNative) {
//            System.out.println(product.getId() + " " + product.getTitle());
//        }
//
//        Optional<Product> product = productRepository.findById(10L);

        Optional<Category> category = categoryRepository.findById(1L);

        if(category.isPresent()) {

            System.out.println(category.get().getName());
            System.out.println(category.get().getProducts());

        }

        System.out.println("Getting Products");

        System.out.println("DEBUG");

    }

}
