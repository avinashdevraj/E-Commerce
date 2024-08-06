package com.example.samplecontroller.controllers;

import com.example.samplecontroller.exceptions.ProductNotFoundException;
import com.example.samplecontroller.models.Product;
import com.example.samplecontroller.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {
    private ProductService productService;
    ProductController(@Qualifier("selfProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") int id) throws ProductNotFoundException {
        //throw new RuntimeException("Something wemnt wrong");
        Product product=null;

            product = productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.FORBIDDEN);
    }

    @GetMapping
    public List<Product> getAllProducts() {

        return productService.getAllProducts();
//        int a=2/0;
//        return null;
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable long id,@RequestBody Product product) {
        return productService.updateProduct(id,product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable long id) {
            productService.deleteProduct(id);
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@RequestBody Product product,@PathVariable long id) {
        return productService.replaceProduct(product);
    }

}
