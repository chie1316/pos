package com.ramirez.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ramirez.pos.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

}
