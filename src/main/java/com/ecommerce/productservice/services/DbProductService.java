package com.ecommerce.productservice.services;

import com.ecommerce.productservice.exceptions.ProductNotFoundException;
import com.ecommerce.productservice.models.Category;
import com.ecommerce.productservice.models.Product;
import com.ecommerce.productservice.repositories.CategoryRepository;
import com.ecommerce.productservice.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("dbProductService")
@Primary
public class DbProductService implements ProductService {

    ProductRepository productRepository;
    CategoryRepository categoryRepository;

    public DbProductService(ProductRepository productRepository, CategoryRepository categoryRepository){

        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(productId);

        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("Product with id: " + productId + "does not exist");
        }

        return optionalProduct.get();
    }

//    @Override
//    public List<Product> getAllProducts() {
//        return productRepository.findAll();
//    }

    // Alternate way: Convert Page<Product> to a List<Product>

    @Override
    public Page<Product> getAllProducts(int pageNumber, int pageSize) {

        Sort sort = Sort.by("price").ascending().and(Sort.by("title").descending());
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return productRepository.findAll(pageable);

    }

    @Override
    public Product addNewProduct(Product product) {

        Category category = product.getCategory();

//        if(category.getId() == null){
//
//            category = categoryRepository.save(category);
//            product.setCategory(category);
//        }

        return productRepository.save(product);
    }

    @Override
    public void deleteSingleProduct(Long productId) throws ProductNotFoundException {
        Optional<Product> productOptional = productRepository.findById(productId);

        if(productOptional.isEmpty()){
            throw new ProductNotFoundException("Product with id: " + productId + "does not exist");
        }

        productRepository.deleteById(productId);
    }

    @Override
    public List<Product> getLimitedProducts(Integer num) {
        return null;
    }

    @Override
    public Product updateProduct(Long productId, Product product) throws ProductNotFoundException {

        Optional<Product> productOptional = productRepository.findById(productId);

        if(productOptional.isEmpty()){
            throw new ProductNotFoundException("Product with id: " + productId + "does not exist");
        }

        Product productInDb = productOptional.get();

        if(product.getTitle() != null) {
            productInDb.setTitle(product.getTitle());
        }

        if(product.getPrice() != null) {
            productInDb.setPrice(product.getPrice());
        }

        return productRepository.save(productInDb);
    }

    @Override
    public Product replaceProduct(Long id, Product product)
            throws ProductNotFoundException {

        productRepository.findById(id)
                .orElseThrow(() ->
                        new ProductNotFoundException(
                                "Product with id " + id + " does not exist"));

        product.setId(id);

        return productRepository.save(product);
    }

}
