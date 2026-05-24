package com.ecommerce.productservice.models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@JsonPropertyOrder({
        "id",
        "title",
        "price",
        "category",
        "createdAt",
        "updatedAt"
})
public class Product extends Base {

    private String title;
    private Double price;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category category;

}
