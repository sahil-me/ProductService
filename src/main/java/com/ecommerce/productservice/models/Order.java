package com.ecommerce.productservice.models;

import jakarta.persistence.*;

@Entity
public class Order {

    @Id
    private Long id;
    private String product;

    @ManyToOne
    private Customer customer;

}
