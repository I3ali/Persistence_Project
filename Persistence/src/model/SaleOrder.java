package model;

import java.time.*;
import java.util.*;
import java.sql.Timestamp;

public class SaleOrder {
    private int id;
    private Timestamp date;
    private double amount;
    private Date deliveryDate;
    private String deliveryStatus;
    private List<OrderLine> cart;

    public SaleOrder(int id, Timestamp date, double amount, String deliveryStatus, Date deliveryDate) {
        id = this.id;
        date = this.date;
        amount = this.amount;
        deliveryDate = this.deliveryDate;
        deliveryStatus = this.deliveryStatus;
    }

    public void setDate(Timestamp date) {
        date = this.date;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setAmount(double amount) {
       amount = this.amount;
    }

    public double getAmount() {
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

    public Integer getId() {
        return id;
    }
}