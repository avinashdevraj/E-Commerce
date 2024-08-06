package com.example.samplecontroller.repositories;

import com.example.samplecontroller.models.Product;
import com.example.samplecontroller.projections.ProductWithIdAndName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Override
    Optional<Product> findById(Long aLong);
    //Optional<Product> findAll();

    Product save(Product product);

    void deleteById(Long aLong);



    @Query("select p from products p where p.price>50000 order by p.price")
    List<Product> somequery();

//    @Query("select p.id as id,p.name as name from products p")
//    List<ProductWithIdAndName> findWithIdTitle();



}
