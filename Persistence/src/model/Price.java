package model;

import java.sql.Timestamp;

public class Price {
	private Timestamp startDate;
	private double price;
	private String priceType;
	private Product product;
	
	public Price(Timestamp startDate, double price, String priceType, Product product) {
		this.setStartDate(startDate);
		this.setPrice(price);
		this.setPriceType(priceType);
		this.setProduct(product);
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
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