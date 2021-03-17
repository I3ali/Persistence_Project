package model;

public class OrderLine {
	private int quantity;
	private int Product;
	
	public OrderLine (int quantity, int Product) {
		this.quantity = quantity;
		this.Product = Product;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the product
	 */
	public int getProduct() {
		return Product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(int product) {
		Product = product;
	}
	
	
}
