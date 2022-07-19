package com.ragnar.Crud.App;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ragnar.Crud.App.model.Product;
import com.ragnar.Crud.App.service.ProductService;

@SpringBootApplication
public class CrudAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(ProductService productService) {
		return (args) -> {

			Product product = new Product();
			product.setProductName("Iphone 6");
			product.setPrice(75000);
			product.setQuantityInStore(12);
			productService.saveProduct(product);
			
		};
	}
}
