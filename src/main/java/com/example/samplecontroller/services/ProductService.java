package com.example.samplecontroller.services;

import com.example.samplecontroller.exceptions.ProductNotFoundException;
import com.example.samplecontroller.models.Product;

import java.util.List;

public interface ProductService {

    Product getProductById(long id) throws ProductNotFoundException;
    List<Product> getAllProducts();
    Product createProduct(Product product);
    Product updateProduct(Long id,Product product);
    void deleteProduct(long id);
    Product replaceProduct(Product product);
}
