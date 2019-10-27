package com.ravi.poc.repository;

import com.ravi.poc.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, String> {
}
