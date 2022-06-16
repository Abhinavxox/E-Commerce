package com.bway.project_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bway.project_2.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
