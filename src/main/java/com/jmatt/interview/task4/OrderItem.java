package com.jmatt.interview.task4;


public class OrderItem {
    double price;
    String productId;
    int quantity;

    /*
    Product details omitted for interview purpose
     */

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = Math.round(price * 100) / 100.0;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "price=" + price +
                ", productId='" + productId + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}