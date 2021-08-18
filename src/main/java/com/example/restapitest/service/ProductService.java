package com.example.restapitest.service;

import java.util.Collection;

import com.example.restapitest.model.Product;

public interface ProductService {
    public abstract void createProduct(Product product);

    public abstract void updateProduct(String id, Product product);

    public abstract void deleteProduct(String id);

    public abstract Collection<Product> getProducts();

}
