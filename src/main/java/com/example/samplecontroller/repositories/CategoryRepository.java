package com.example.samplecontroller.repositories;

import com.example.samplecontroller.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category save(Category category);

    void deleteById(Long id);
}
