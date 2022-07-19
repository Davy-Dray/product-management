package com.ragnar.Crud.App.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ragnar.Crud.App.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	//Page<Product> findAll(Pageable pageable);

}
