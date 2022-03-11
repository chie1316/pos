package com.ramirez.pos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ramirez.pos.dto.ProductDto;
import com.ramirez.pos.entity.Product;
import com.ramirez.pos.projection.ProductView;
import com.ramirez.pos.repository.ProductRepository;

@Service
public class ProductServiceImpl implements InventoryService {

	@Autowired
	private ProductRepository productRepo;

	@Override
	public String addProduct(ProductDto productDto) {
		String message = "The Product '" + productDto.getName() + "' was successfully added";

		Product product = new Product(productDto.getName(), productDto.getCode(), productDto.getCost(),
				productDto.getQuantity(), productDto.getPrice());

		try {
			productRepo.save(product);
		} catch (Exception e) {
			message = "An error occur while adding Product";
		}

		return message;
	}

	@Override
	public Page<ProductView> getProductList(Pageable pageable) {

		return productRepo.getProductList(pageable);
	}

	@Override
	public ProductDto getProductById(String id) {
		Optional<Product> op = productRepo.findById(id);

		if (op.isPresent()) {
			Product product = op.get();
			return new ProductDto(product.getId(), product.getName(), product.getCode(), product.getCost(),
					product.getQuantity(), product.getPrice());
		}
		return null;
	}

	@Override
	public String updateProduct(ProductDto productDto) {
		String message = "The Product '" + productDto.getName() + "' was successfully updated";

		Product product = new Product(productDto.getId(), productDto.getName(), productDto.getCode(),
				productDto.getCost(), productDto.getQuantity(), productDto.getPrice());

		try {
			productRepo.save(product);
		} catch (Exception e) {
			message = "An error occur while updating Product";
		}

		return message;
	}

	@Override
	public String deleteProduct(String id) {

		String message;
		try {
			Optional<Product> op = productRepo.findById(id);

			if (op.isPresent()) {
				productRepo.delete(op.get());
				message = "The product '" + op.get().getName() + "' was successfully deleted";
			} else {
				message = "Failed to delete product";
			}

		} catch (Exception e) {
			message = "An error occur while deleting Product";
		}
		return message;
	}

	@Override
	public String deleteMultipleProduct(List<String> idList) {
		String message;
		try {
			productRepo.deleteAllById(idList);
			message = "Multiple product was successfully deleted";

		} catch (Exception e) {
			message = "An error occur while deleting multiple Product";
		}

		return message;
	}

}
