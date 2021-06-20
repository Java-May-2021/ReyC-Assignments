package com.reymer.productandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reymer.productandcategories.models.Category;
import com.reymer.productandcategories.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {
	List<Category> findAll();
	List<Category> findByProductsNotContaining(Product product);
}
