package com.ecommerce.productservice.services;

import com.ecommerce.productservice.exceptions.ProductNotFoundException;
import com.ecommerce.productservice.models.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    Product getSingleProduct(Long productId) throws ProductNotFoundException;

//    List<Product> getAllProducts();

    Page<Product> getAllProducts(int pageNumber, int pageSize);

    Product addNewProduct(Product product);

    void deleteSingleProduct(Long product_id) throws ProductNotFoundException;

    List<Product> getLimitedProducts(Integer num);

    Product updateProduct(Long id, Product product) throws ProductNotFoundException;

    Product replaceProduct(Long id, Product product) throws ProductNotFoundException;
}
