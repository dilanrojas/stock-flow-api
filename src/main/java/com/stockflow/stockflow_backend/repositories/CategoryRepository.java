package com.stockflow.stockflow_backend.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockflow.stockflow_backend.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    default List<Category> getAll(){
        return findAll();
    }
    
    default Category addCategory(Category category){
        return save(category);
    }

    default Category updateCategory(Category category){
        return save(category);
    }

    default void removeCategory(Category category){
        delete(category);
    }

    Optional<Category> findByResourceId(UUID resourceId);

}
