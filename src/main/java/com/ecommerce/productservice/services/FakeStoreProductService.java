package com.ecommerce.productservice.services;

import com.ecommerce.productservice.dtos.FakeStoreProductDto;
import com.ecommerce.productservice.models.Category;
import com.ecommerce.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {

    RestTemplate restTemplate;
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long productId) {

        FakeStoreProductDto fakeStoreProductDto =
                restTemplate.getForObject("https://fakestoreapi.com/products/1" + productId,
                FakeStoreProductDto.class);

        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {

        FakeStoreProductDto[] fakeStoreProductDtos =
                restTemplate.getForObject("https://fakestoreapi.com/products",
                        FakeStoreProductDto[].class);

        List<Product> products = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            products.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
        }

        return products;
    }

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {

        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());

        product.setCategory(new Category(fakeStoreProductDto.getCategory(),
                fakeStoreProductDto.getDescription()));
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());

        return product;
    }

}
