package com.example.restapitest.controller;

import com.example.restapitest.model.Product;
import com.example.restapitest.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductServiceController {

    @Autowired
    ProductService productService;

    @GetMapping(value = "/products")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<Object> getProduct() {
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @PostMapping(value = "/products")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        productService.createProduct(product);
        return new ResponseEntity<>("Product is created successfully!", HttpStatus.CREATED);
    }

    @PutMapping(value = "/products/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
        productService.updateProduct(id, product);
        return new ResponseEntity<>("Product is updated successfully!", HttpStatus.OK);
    }

    @DeleteMapping(value = "/products/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable("id") String id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product is deleted successfully!", HttpStatus.OK);
    }
}
