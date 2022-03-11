package com.ramirez.pos.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ramirez.pos.dto.ProductDto;
import com.ramirez.pos.projection.ProductView;

@Service
public interface InventoryService {

	public String addProduct(ProductDto productDto);

	public Page<ProductView> getProductList(Pageable pageable);

	public ProductDto getProductById(String id);

	public String updateProduct(ProductDto productDto);

	public String deleteProduct(String id);

	public String deleteMultipleProduct(List<String> idList);
}
