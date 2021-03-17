package model;

import java.time.LocalDateTime;

public class Price {
	private LocalDateTime startDate;
	private double price;
	private String priceType;
	private Product product;
	
	public Price(LocalDateTime startDate, double price, String priceType, Product product) {
		this.startDate = startDate;
		this.price = price;
		this.priceType = priceType;
		this.product = product;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPriceType() {
		return priceType;
	}

	public void setPriceType(String priceType) {
		this.priceType = priceType;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
