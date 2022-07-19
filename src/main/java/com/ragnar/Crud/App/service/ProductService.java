package com.ragnar.Crud.App.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ragnar.Crud.App.model.Product;

public interface ProductService {

	List<Product> getAllProducts();

	void saveProduct(Product product);

	Product getProduct(long id);

	void deleteProduct(long id);

	Page<Product> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
