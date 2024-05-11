package com.tp.ms.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tp.ms.product.model.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

}
