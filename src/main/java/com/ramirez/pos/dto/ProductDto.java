package com.ramirez.pos.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.ramirez.pos.validation.CustomDecimalConstraint;
import com.ramirez.pos.validation.CustomIntegerConstraint;

public class ProductDto {

	private String id;

	@NotBlank(message = "Product Name is required!")
	private String name;

	@NotBlank(message = "Product Code is required!")
	private String code;

	@CustomDecimalConstraint(message = "Enter a valid Product Cost!")
	@Min(value = 0L)
	private Double cost;

	@CustomIntegerConstraint(message = "Enter a valid Product Quantity!")
	@Min(value = 0L)
	private Integer quantity;

	@CustomDecimalConstraint(message = "Enter a valid Product Price!")
	@Min(value = 0L)
	private Double price;

	public ProductDto(String id, String name, String code, Double cost, Integer quantity, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.cost = cost;
		this.quantity = quantity;
		this.price = price;
	}

	public ProductDto() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
