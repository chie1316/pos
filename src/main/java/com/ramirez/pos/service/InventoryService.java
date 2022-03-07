package com.ramirez.pos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ramirez.pos.dto.ProductDto;
import com.ramirez.pos.entity.Product;

@Service
public interface InventoryService {

	public String addProduct(ProductDto productDto);

	public List<Product> getProductList();

	public Product getProductById(String id);

	public String updateProduct(ProductDto productDto);

	public String deleteProduct(String id);

	public String deleteMultipleProduct(List<String> idList);
}
