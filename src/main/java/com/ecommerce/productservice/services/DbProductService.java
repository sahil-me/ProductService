package com.ecommerce.productservice.services;

import com.ecommerce.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class DbProductService implements ProductService {

    @Override
    public Product getSingleProduct(Long productId) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }
}
