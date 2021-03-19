package model;

import model.Product;
import model.SaleOrder;

public class OrderLine {
	private int quantity;
	private int productId;
	private int saleOrderId;
	
	public OrderLine (int quantity, int productId, int saleOrderId) {
		this.setSaleOrderId(saleOrderId);
		this.setProductId(productId);
		this.setQuantity(quantity);
	}

	public int getSaleOrderId() {
		return saleOrderId;
	}

	public void setSaleOrderId(int saleOrderId) {
		this.saleOrderId = saleOrderId;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}	
}