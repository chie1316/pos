package com.ramirez.pos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ramirez.pos.dto.ProductDto;
import com.ramirez.pos.entity.Product;
import com.ramirez.pos.service.InventoryService;

@Controller
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;

	@RequestMapping("/")
	public String startPage() {
		return "layout";
	}
	
	@GetMapping("/product")
	public String getProductList(Model model) {
		model.addAttribute("Products", inventoryService.getProductList());
		return "inventory_list";
	}

	@GetMapping("/product/id")
	public ResponseEntity<Product> getProductById(@RequestParam("product_id") String id) {
		Product product = inventoryService.getProductById(id);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@RequestMapping("/product/add-product")
	public String addProduct(@ModelAttribute ProductDto productDto) {
		return inventoryService.addProduct(productDto);
	}

}
