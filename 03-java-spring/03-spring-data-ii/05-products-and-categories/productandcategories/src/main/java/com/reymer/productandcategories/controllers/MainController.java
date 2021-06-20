package com.reymer.productandcategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.reymer.productandcategories.models.Category;
import com.reymer.productandcategories.models.Product;
import com.reymer.productandcategories.services.MainService;

@Controller
public class MainController {
	private final MainService mainService;
	public MainController(MainService mainService) {
		this.mainService = mainService;
	}
	
	@GetMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "products/newProduct.jsp";
	}
	@PostMapping("/products/new")
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "products/newProduct.jsp";
		}
		this.mainService.createProduct(product);
		return "redirect:/";
	}
	@GetMapping("/products/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		Product product = this.mainService.getSingleProduct(id);
		model.addAttribute("product", product);
		model.addAttribute("categories", this.mainService.getAllCategoriesNotContainingProduct(product));
		return "products/showProduct.jsp";
	}
	@GetMapping("categories/add/{id}")
	public String addCategory(@PathVariable("id")Long id, @RequestParam(value="categoryId") Long categoryId) {
		Product product = this.mainService.getSingleProduct(id);
		Category category  = this.mainService.getSingleCategory(categoryId);
		List<Category> categories = product.getCategories();
		categories.add(category);
		this.mainService.updateProduct(product);
		return "redirect:/products/{id}";
	}
	
	@GetMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "categories/newCategory.jsp";
	}
	@PostMapping("/categories/new")
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "categories/newCategory.jsp";
		}
		this.mainService.createCategory(category);
		return "redirect:/";
	}
	@GetMapping("/categories/{id}")
	public String showCategory(@PathVariable("id") Long id, Model model) {
		Category category = this.mainService.getSingleCategory(id);
		model.addAttribute("category", category);
		model.addAttribute("products", this.mainService.getAllProductsNotContainingCategory(category));
		return "categories/showCategory.jsp";
	}
	@GetMapping("products/add/{id}")
	public String addProduct(@PathVariable("id")Long id, @RequestParam(value="productId") Long productId) {
		Category category = this.mainService.getSingleCategory(id);
		Product product  = this.mainService.getSingleProduct(productId);
		List<Product> products = category.getProducts();
		products.add(product);
		this.mainService.updateCategory(category);
		return "redirect:/categories/{id}";
	}
	@GetMapping("/")
	public String showAll(Model model) {
		model.addAttribute("products", this.mainService.getAllProducts());
		model.addAttribute("categories", this.mainService.getAllCategories());
		return "index.jsp";
	}
}
