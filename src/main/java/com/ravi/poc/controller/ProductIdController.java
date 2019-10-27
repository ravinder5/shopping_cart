package com.ravi.poc.controller;

import com.ravi.poc.model.Product;
import com.ravi.poc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/products")
public class ProductIdController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping(value = "/{id}")
    public Optional<Product> getProduct(@PathVariable String id){
        Optional<Product> product = productRepository.findById(id);
        return product;
    }

    @PostMapping()
    public Product addProduct(@RequestBody Product newProduct){
        Product product = new Product(newProduct.getProduct_id(), newProduct.getProduct_name(), newProduct.getProduct_price());
        productRepository.save(product);
        return product;
    }

    @PutMapping(value = "/{id}")
    public Optional<Product> updateProduct(@RequestBody Product newProduct, @PathVariable String id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()) {
            Product product = new Product(newProduct.getProduct_id(), newProduct.getProduct_name(), newProduct.getProduct_price());
            productRepository.save(product);
        }
        return optionalProduct;
    }

    @DeleteMapping(value = "/{id}")
    public String deleteProduct(@PathVariable String id){
        Boolean optionalProduct = productRepository.existsById(id);
        productRepository.deleteById(id);
        return "{ \"success\" : "+ (optionalProduct ? "true" : "false") +" }";
    }
}
