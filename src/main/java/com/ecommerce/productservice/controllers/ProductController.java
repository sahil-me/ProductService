package com.ecommerce.productservice.controllers;

import com.ecommerce.productservice.exceptions.ProductNotFoundException;
import com.ecommerce.productservice.models.Product;
import com.ecommerce.productservice.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {

        ResponseEntity<Product> responseEntity = new ResponseEntity<>(
                productService.getSingleProduct(id),
                HttpStatus.OK
        );

        return responseEntity;
    }

    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/limit/{num}")
    public List<Product> getLimitedProducts(@PathVariable("num") Integer num){
        return  productService.getLimitedProducts(num);
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.replaceProduct(id, product);
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }
}
