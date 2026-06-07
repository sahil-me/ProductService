# 🛒 E-Commerce Platform 🛍

https://github.com/user-attachments/assets/98d4aca9-11f5-4c16-b068-7e25ab371ca7

> 🎥 Product Service Demonstration!

---

## Table of Contents
- [Introduction](#introduction)
- [Project Structure](#project-structure)
- [Tech Stack](#tech-stack)
- [Product Requirements Document (PRD)](#product-requirements-document-prd)
  - [Functional Requirements](#functional-requirements)
    - [User Management](#1%EF%B8%8F⃣-user-management)
    - [Product Catalog](#2%EF%B8%8F⃣-product-catalog)
    - [Cart & Checkout](#3%EF%B8%8F⃣-cart--checkout)
    - [Order Management](#4%EF%B8%8F⃣-order-management)
    - [Payment](#5%EF%B8%8F⃣-payment)
    - [Authentication](#6%EF%B8%8F⃣-authentication)
  - [High-Level Design (HLD)](#high-level-design-hld)
    - [Architecture Components](#architecture-components)
      - [Load Balancers (LB)](#architecture-components)
      - [API Gateway](#architecture-components)
      - [Microservices Architecture](#architecture-components)
      - [Databases](#architecture-components)
      - [Message Broker (Kafka)](#architecture-components)
      - [Caching (Redis)](#architecture-components)
      - [Search & Analytics (Elasticsearch)](#architecture-components)      
  - [Typical Flow](#typical-flow)
    - [Part 1: Product Search](#part-1-product-search)
    - [Part 2: Add to Cart](#part-2-add-to-cart)
    - [Part 3: Checkout](#part-3-checkout)
- [Resources](#resources)
- [Contributing](#contributing)
- [License](#license)
- [Author](#author)

---

## Introduction

A scalable and modular e-commerce platform built using a microservices architecture. The system is designed to handle core e-commerce functionalities such as product management, cart operations, order processing, payment integration, and user management through independently deployable backend services.

The project demonstrates real-world backend engineering concepts including RESTful APIs, database design, asynchronous communication, scalability, service abstraction, caching, payment gateway integration, and microservices-based system design using Spring Boot and related technologies.

---

## Project Structure

    E-Commerce-Platform/
    │
    ├── ServiceDiscovery/   # Eureka Service Registry
    ├── ApiGateway/         # API Gateway
    ├── UserService/        # User Management
    ├── ProductService/     # Product Catalog Management
    ├── PaymentService/     # Payment Integration
    └── EmailService/       # Email Notifications      

---

## Tech Stack

  | Technology                         | Purpose                                  |
  | ---------------------------------- | ---------------------------------------- |
  | Java 17                            | Core Programming Language                |
  | Spring Boot 3.4                    | Application Framework                    |
  | Spring Web                         | RESTful API Development                  |
  | Spring Data JPA                    | Database Persistence Layer               |
  | MySQL                              | Primary Relational Database              |
  | Redis                              | Distributed Caching                      |
  | Spring Cloud Netflix Eureka Client | Service Discovery                        |
  | Lombok                             | Boilerplate Code Reduction               |
  | Maven                              | Build Automation & Dependency Management |
  | JUnit 5                            | Testing Framework                        |
  | Spring Boot DevTools               | Development & Hot Reload Support         |
  | IntelliJ IDEA                      | Integrated Development Environment       |


---

## Product Requirements Document (PRD)

### Functional Requirements

### 1️⃣ User Management
- **Registration**: Allow users to register via email or social media profiles.
- **Login**: Secure user login with credentials.
- **Profile Management**: Enable users to view and edit their profiles.
- **Password Reset**: Allow password resets through secure email links.

### 2️⃣ Product Catalog
- **Browsing**: Users can browse products by category.
- **Product Details**: Product pages include images, descriptions, specifications, and more.
- **Search**: Provide search functionality with keyword-based queries.

### 3️⃣ Cart & Checkout
- **Add to Cart**: Users can add products to their cart.
- **Cart Review**: View selected items with price, quantity, and totals.
- **Checkout**: Seamless process to finalize purchases, including delivery details and payment options.

### 4️⃣ Order Management
- **Order Confirmation**: Confirm orders with details after purchase.
- **Order History**: Allow users to view past orders.
- **Order Tracking**: Provide delivery status tracking.

### 5️⃣ Payment
- **Multiple Payment Options**: Support credit/debit cards, online banking, and other methods.
- **Secure Transactions**: Ensure secure payment handling.
- **Payment Receipt**: Generate receipts for successful payments.

### 6️⃣ Authentication
- **Secure Authentication**: Protect user data during login and active sessions.
- **Session Management**: Allow users to stay logged in until they log out or after a specified duration.

## High-Level Design (HLD)

### Architecture Components

1️⃣ **Load Balancers (LB)**: Distribute traffic across servers for high availability (e.g., AWS ELB).

2️⃣ **API Gateway**: Entry point for routing requests, managing rate limits, and handling authentication (e.g., Kong).

3️⃣ **Microservices**: Separate services for modular and scalable architecture.

4️⃣ **Databases**: MySQL and MongoDB for structured and unstructured data.

5️⃣ **Message Broker (Kafka)**: Enable asynchronous inter-service communication.

6️⃣ **Caching (Redis)**: Boost response times for frequently accessed data.

7️⃣ **Search & Analytics (Elasticsearch)**: Efficient product searches with advanced capabilities.

## Typical Flow

### Part 1: Product Search
1️⃣ User logs in and searches for a product.

2️⃣ Request passes through the Load Balancer to the API Gateway.

3️⃣ API Gateway routes the search request to the Product Catalog Service.

4️⃣ Product Catalog Service queries Elasticsearch for results.

### Part 2: Add to Cart
1️⃣ User adds a product to the cart.

2️⃣ Cart Service stores the item in MongoDB and produces a Kafka message.

### Part 3: Checkout
1️⃣ User checks out.

2️⃣ Order Management Service processes the order and sends a Kafka message.

3️⃣ Payment Service consumes the message to handle payment.

---

## Resources

[![Dependency Injection](https://img.shields.io/badge/Spring-Dependency%20Injection-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://docs.spring.io/spring-framework/reference/core/beans/dependencies/factory-collaborators.html)
[![Spring Data JPA](https://img.shields.io/badge/Spring%20Data-JPA-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://spring.io/projects/spring-data-jpa)
[![Hibernate ORM](https://img.shields.io/badge/Hibernate-ORM-59666C?style=for-the-badge&logo=hibernate&logoColor=white)](https://hibernate.org/orm/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-Documentation-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)](https://docs.spring.io/spring-boot/index.html)
[![REST Template](https://img.shields.io/badge/Spring-REST%20Template-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://www.baeldung.com/rest-template)
[![Java UUID](https://img.shields.io/badge/Java-UUID-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.baeldung.com/java-uuid)
[![JDBC](https://img.shields.io/badge/Java-JDBC-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://docs.oracle.com/javase/tutorial/jdbc/)
[![ORM](https://img.shields.io/badge/Hibernate-ORM-59666C?style=for-the-badge&logo=hibernate&logoColor=white)](https://www.baeldung.com/cs/object-relational-mapping)
[![Microservices](https://img.shields.io/badge/Spring-Microservices-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://spring.io/microservices)
[![Hibernate Inheritance](https://img.shields.io/badge/Hibernate-Inheritance-59666C?style=for-the-badge&logo=hibernate&logoColor=white)](https://www.baeldung.com/hibernate-inheritance)
[![MySQL Integration](https://img.shields.io/badge/Spring-MySQL%20Integration-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://spring.io/guides/gs/accessing-data-mysql)
[![JPA Cascade Types](https://img.shields.io/badge/JPA-Cascade%20Types-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://www.baeldung.com/jpa-cascade-types)
[![JPQL & HQL](https://img.shields.io/badge/JPA-JPQL%20%26%20HQL-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://www.baeldung.com/jpql-hql-criteria-query#hql)
[![Spring Data Queries](https://img.shields.io/badge/Spring%20Data-Query%20Methods-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html)
[![AWS EC2](https://img.shields.io/badge/AWS-EC2-FF9900?style=for-the-badge&logo=amazonaws&logoColor=white)](https://medium.com/edureka/aws-ec2-tutorial-16583cc7798e)
[![Redis](https://img.shields.io/badge/Redis-Caching-DC382D?style=for-the-badge&logo=redis&logoColor=white)](https://www.baeldung.com/spring-data-redis-tutorial)
[![Scalable Architecture](https://img.shields.io/badge/System-Scalable%20Architecture-4285F4?style=for-the-badge&logo=googlecloud&logoColor=white)](https://gist.github.com/jboner/2841832)
[![Pagination & Sorting](https://img.shields.io/badge/Spring%20Data-Pagination%20%26%20Sorting-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://www.baeldung.com/spring-data-jpa-pagination-sorting)

---

## Contributing

Contributions are welcome. Before submitting changes, please review:
- [Contributing Guide](./Contributing.md)
- [Code of Conduct](./CODE_OF_CONDUCT.md)
- [Security Policy](./.github/SECURITY.md)

---

## License
This project is licensed under the [Apache 2.0 License](./LICENSE).

---

## Author

[**Sahil Sharma**](https://github.com/sahil-me)

Thank you for exploring this project. If you find it helpful, consider giving the repository a ⭐ to support its continued development.

