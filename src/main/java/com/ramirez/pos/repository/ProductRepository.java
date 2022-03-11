package com.ramirez.pos.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ramirez.pos.entity.Product;
import com.ramirez.pos.projection.ProductView;

public interface ProductRepository extends JpaRepository<Product, String> {

	@Query("select p from Product p")
	public Page<ProductView> getProductList(Pageable pageable);
}
