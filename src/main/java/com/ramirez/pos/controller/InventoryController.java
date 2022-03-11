package com.ramirez.pos.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ramirez.pos.dto.MainResponse;
import com.ramirez.pos.dto.ProductDto;
import com.ramirez.pos.entity.User;
import com.ramirez.pos.enumerator.ResponseCode;
import com.ramirez.pos.enumerator.ResponseTitle;
import com.ramirez.pos.projection.ProductView;
import com.ramirez.pos.service.InventoryService;

@Controller
public class InventoryController {

	private final int PAGE_SIZE = 5;

	@Autowired
	private InventoryService inventoryService;

	@GetMapping("/error")
	public String showErrorPage() {
		return "error_page";
	}

	@GetMapping("/register")
	public String testRegister(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "register_form";
	}

	@PostMapping("/register")
	public String submitForm(@ModelAttribute("user") User user) {
		return "register_success";
	}

	@GetMapping("/product")
	public String productView(@RequestParam(defaultValue = "0") int page, Model model) {

		Pageable pageable = PageRequest.of(page, PAGE_SIZE);
		Page<ProductView> productList = inventoryService.getProductList(pageable);
		ProductDto addProductDto = new ProductDto();

		model.addAttribute("productList", productList);
		model.addAttribute("currentPage", page);
		model.addAttribute("addProductDto", addProductDto);
		return "product";
	}

	@PostMapping("/product")
	public String addProduct(@Valid @ModelAttribute("addProductDto") ProductDto addProductDto,
			BindingResult bindingResult, Model model) {

		String message;
		if (bindingResult.hasErrors()) {
			message = "Invalid Input";
		} else {
			message = inventoryService.addProduct(addProductDto);
		}

		MainResponse<String> addProductResponse = new MainResponse<>(ResponseCode.SUCCESS, ResponseTitle.ADD_PRODUCT,
				message, message);
		model.addAttribute("addProductResponse", addProductResponse);

		return "redirect:/product";
	}
}
