package com.reymer.productandcategories.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.reymer.productandcategories.models.Category;
import com.reymer.productandcategories.models.Product;
import com.reymer.productandcategories.repositories.CategoryRepository;
import com.reymer.productandcategories.repositories.ProductRepository;

@Service
public class MainService {
	private final ProductRepository prodRepo;
	private final CategoryRepository catRepo;
	public MainService(ProductRepository prodRepo, CategoryRepository catRepo) {
		this.prodRepo = prodRepo;
		this.catRepo = catRepo;
	}
	
	// Product
	public List<Product> getAllProducts() {
		return this.prodRepo.findAll();
	}
	public Product getSingleProduct(Long id) {
		return this.prodRepo.findById(id).orElse(null);
	}
	public List<Product> getAllProductsNotContainingCategory(Category category) {
		return this.prodRepo.findByCategoriesNotContaining(category);
	}
	public Product createProduct(Product product) {
		return this.prodRepo.save(product);
	}
	public Product updateProduct(Product product) {
		return this.prodRepo.save(product);
	}
	
	// Category
	public List<Category> getAllCategories() {
		return this.catRepo.findAll();
	}
	public Category getSingleCategory(Long id) {
		return this.catRepo.findById(id).orElse(null);
	}
	public List<Category> getAllCategoriesNotContainingProduct(Product product) {
		return this.catRepo.findByProductsNotContaining(product);
	}
	public Category createCategory(Category category) {
		return this.catRepo.save(category);
	}
	public Category updateCategory(Category category) {
		return this.catRepo.save(category);
	}
}
