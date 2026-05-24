package com.ecommerce.productservice.repositories;

import com.ecommerce.productservice.models.Product;
import com.ecommerce.productservice.projections.ProductWithIdAndTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

//     Product Repo - should contain all the methods(CRUD) related to the Product model

//     select * from products where price >
     List<Product> findProductByPriceGreaterThan(Double price);

//     select * from products where title like '%iphone%'
     List<Product> findProductByTitleLike(String title);

//     select * from products where title like 'iphone' LIMIT 5
     List<Product> findProductByTitleLike(int top, String title);

     List<Product> findByPriceBetween(Double p1, Double p2);

     @Query("select p.id as id, p.title as title from Product p")
     List<ProductWithIdAndTitle> randomSearchMethodForProduct();

     @Query("select p.id as id, p.title as title from Product p where p.id = :id")
     ProductWithIdAndTitle randomSearchMethodForProduct(Long id);

     // Native Queries: SQL
     @Query(nativeQuery = true, value="select p.id as id, p.title as title from product p")
     List<ProductWithIdAndTitle> nativeSearchMethodForProduct();

}
