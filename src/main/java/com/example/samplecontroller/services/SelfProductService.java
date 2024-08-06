package com.example.samplecontroller.services;

import com.example.samplecontroller.models.Category;
import com.example.samplecontroller.models.Product;
import com.example.samplecontroller.repositories.CategoryRepository;
import com.example.samplecontroller.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
//@Primary
public class SelfProductService implements ProductService{
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    SelfProductService(ProductRepository productRepository,CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product getProductById(long id)  {
        Optional<Product> optionalProduct=productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            return null;
        }
        return optionalProduct.get();
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> p= productRepository.findAll();
        return productRepository.somequery();
    }

    @Override
    public Product createProduct(Product product) {
        Category category=product.getCategory();
        if(category.getId()==null){
            Category newCategory=categoryRepository.save(category);
            product.setCategory(newCategory);
        }
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id,Product product) {
        Optional<Product> optionalProduct=productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new RuntimeException("Product not found");
        }
        if(product==null) throw new RuntimeException("Product not found");
        Product product1=optionalProduct.get();
        if(product.getName()!=null){
            product1.setName(product.getName());
        }
        if(product.getDescription()!=null){
            product1.setDescription(product.getDescription());
        }
        if(product.getCategory()!=null){
            product1.setCategory(product.getCategory());
        }
        return productRepository.save(product1);
    }

    @Override
    public void deleteProduct(long id) {
          productRepository.deleteById(id);
    }

    @Override
    public Product replaceProduct(Product product) {
        return productRepository.save(product);
    }
}
