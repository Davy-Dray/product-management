package com.ragnar.Crud.App.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ragnar.Crud.App.model.Product;
import com.ragnar.Crud.App.service.ProductService;

@Controller
public class ProductController {

	final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping(value = { "/", "/index" })
	public String contextPage(Model model) {

		List<Product> listProducts = productService.getAllProducts();

		model.addAttribute("listProducts", listProducts);

		return "index";
	}

	@GetMapping(value = "/showNewProductForm")
	public String showNewProductForm(Model model) {
		
		Product product = new Product();
		model.addAttribute("product", product);
		return "Product-form";
	}

	@GetMapping(value = "/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable("id") long id, Model model) {

		Product product = productService.getProduct(id);

		model.addAttribute("product", product);
		return "Product-form";
	}

	@PostMapping(value = "/saveProduct")
	public String saveProduct(@ModelAttribute("product") Product product) {
		
		productService.saveProduct(product);
		return "redirect:/";
	}

	@GetMapping(value = "/deleteProduct/{id}")
	public String deleteProduct(@PathVariable("id") long id) {

		productService.deleteProduct(id);
		return "redirect:/";
	}

}
