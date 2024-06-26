package com.ivymodal.repository;

import com.ivymodal.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
    Boolean existsByName(String name);

    List<Category> findByMenuParentId(String menuParentId);

    @Query("SELECT c FROM Category c WHERE c.name = :name ")
    Optional<Category> findCategoryByName(String name);

    @Query("SELECT c FROM Category c WHERE c.menuParentId = :id")
    List<Category> findCategoryByMenuParentId(String id);
}
