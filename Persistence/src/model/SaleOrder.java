package model;

import java.time.*;
import java.util.*;



public class SaleOrder {
    private int id;
    private LocalDateTime date;
    private float amount;
    private Date deliveryDate;
    private String deliveryStatus;
    private int customer;
    private int invoice;
    private List<OrderLine> cart;

    public SaleOrder(int id, LocalDateTime date, float amount, String deliveryStatus, Date deliveryDate, int customer, int invoice) {
        this.setId(id);
        this.setDate(date);
        this.setAmount(amount);
        this.setDeliveryDate(deliveryDate);
        this.setDeliveryStatus(deliveryStatus);
        this.setCustomer(customer);
        this.setInvoice(invoice);
        cart = new ArrayList<>();
    }

    public void setDate(LocalDateTime date) {
        date = this.date;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setAmount(float amount) {
       amount = this.amount;
    }

    public float getAmount() {
        return amount;
    }
    
    public void setDeliveryDate(Date deliveryDate) {
        deliveryDate = this.deliveryDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        deliveryStatus = this.deliveryStatus;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void addToCart(OrderLine order) {
        cart.add(order);
    }

    public List<OrderLine> getCart() {
        return cart;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getInvoice() {
    	return invoice;
    }
    
    public void setInvoice(int invoice) {
    	invoice = this.invoice;
    }
    
    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }
}