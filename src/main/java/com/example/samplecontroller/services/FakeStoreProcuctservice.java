package com.example.samplecontroller.services;

import com.example.samplecontroller.dtos.FakeStoreProductDto;
import com.example.samplecontroller.exceptions.ProductNotFoundException;
import com.example.samplecontroller.models.Category;
import com.example.samplecontroller.models.Product;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service("fakeStoreService")
//@Primary
public class FakeStoreProcuctservice implements ProductService{
    private RestTemplate restTemplate;
    FakeStoreProcuctservice( RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    private Product convertFakeProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();

        product.setId(fakeStoreProductDto.getId());
        product.setName(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImage(fakeStoreProductDto.getImageUrl());
        Category category = new Category();
        category.setId(fakeStoreProductDto.getId());
        category.setName(fakeStoreProductDto.getTitle());
        product.setCategory(category);
        return product;
    }

    @Override
    public Product getProductById(long id) throws ProductNotFoundException {
        throw new ProductNotFoundException(id,"Wrong product id");

//        FakeStoreProductDto fakeStoreProductDto= restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
//        //Convert fakedto to product to return it.
//        if(fakeStoreProductDto==null)
//            throw new ProductNotFoundException(id,"Wrong product id");
       //return convertFakeProductDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] fakeStoreProductsDtoList=
                restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDto[].class);
        List<Product> productList=new ArrayList<>();
        if(fakeStoreProductsDtoList==null) {
            return productList;
        }

        for(FakeStoreProductDto p: fakeStoreProductsDtoList){
            productList.add(convertFakeProductDtoToProduct(p));
            //System.out.println(p);

        }
        return productList;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Long id,Product product) {
        return null;
    }

    @Override
    public void deleteProduct(long id) {
        System.out.println();
    }

    @Override
    public Product replaceProduct(Product product) {
        //PUT request replace the object with given id in input and return updated product.
        /*PUT cannot be used directly as PUT return type is void and oue is returning Product
          so,when we deep-dived into(RestTemplate Class) we found underline metgod exexuted by PUT is execute so we copy that method and changed
          accordingly coz it return <T>.
         */
        RequestCallback requestCallback = restTemplate.httpEntityCallback(product, FakeStoreProductDto.class);
        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor = new HttpMessageConverterExtractor(FakeStoreProductDto.class, restTemplate.getMessageConverters());
        FakeStoreProductDto fakeStoreProductDto= restTemplate.execute("https://fakestoreapi.com/products/"+product.getId(), HttpMethod.PUT, requestCallback, responseExtractor);
        if(fakeStoreProductDto==null) return null;
        return convertFakeProductDtoToProduct(fakeStoreProductDto);

    }
}
