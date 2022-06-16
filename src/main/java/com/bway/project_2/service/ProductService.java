package com.bway.project_2.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bway.project_2.model.Product;
import com.bway.project_2.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepo;
	
	public Optional<Product> findByID(int id){
		
		return productRepo.findById(id);
	}

}
