package com.example.samplecontroller;

import com.example.samplecontroller.models.Product;
import com.example.samplecontroller.projections.ProductWithIdAndName;
import com.example.samplecontroller.repositories.CategoryRepository;
import com.example.samplecontroller.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SampleControllerApplicationTests {

    @Autowired
    private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Test
	void contextLoads() {

	}

	@Test
	void getProduct() {
		List<Product> products = productRepository.findAll();

		System.out.println("DEBUG");
	}

	@Test
	void getProductWithIdTitle() {
		//List<ProductWithIdAndName> products = productRepository.findWithIdTitle();

		System.out.println("DEBUG");

		categoryRepository.deleteById(1L);
	}

}
