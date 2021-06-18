package com.skillstorm.models;

/**
 * 10-15 tables, 30-50 columns (75% optional)
 * 
 * Builder design pattern: complex object initialization, but many features are
 * optional
 * 
 */
public class Product {

	private int id;
	private String name;
	private String description;
	private double price;
	private Category category;

	public class Builder {
		Product object = new Product();
		Category category = new Category();
		
		public Builder id(int id) {
			object.setId(id);
			return this;
		}
		
		public Builder name(String name) {
			object.setName(name);
			return this;
		}
		
		public Builder description(String description) {
			object.setDescription(description);
			return this;
		}
		
		public Builder price(double price) {
			object.setPrice(price);
			return this;
		}
		
		public Builder categoryName(String name) {
			category.setName(name);
			return this;
		}
		
		public Product build() {
			object.setCategory(category);
			return object;
		}

	}

	public Product() {
		super();
	}

	public Product(int id, String name, String description, double price, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", category=" + category + "]";
	}

}
