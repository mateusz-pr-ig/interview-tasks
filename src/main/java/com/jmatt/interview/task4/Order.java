package com.jmatt.interview.task4;

import java.util.Date;
import java.util.List;

public class Order {
    long orderId;
    List<OrderItem> orderItems;
    OrderStatus status;
    Date orderDate;
    boolean isPaid;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Order reserveAndPayForOrder(Order order, double paidPrice) {

        OrderStatus reservedOrder = new OrderStatus();
        reservedOrder.setStatusId(1);
        order.setStatus(reservedOrder);
        order.setOrderDate(new Date());

        double totalPrice = 0;
        for (int i = 0; i < order.getOrderItems().size(); i++) {
            double tmpPrice = order.getOrderItems().get(i).getPrice();
            totalPrice += tmpPrice;
        }

        if (paidPrice >= totalPrice) {
            OrderStatus paidOrder = new OrderStatus();
            paidOrder.setStatusId(2);
            order.setStatus(paidOrder);
            isPaid = true;
        }

        return order;
    }

    @Override
    public String toString() {
        return "OrderId: " + orderId + ", orderItems: " + orderItems + ", OrderStatus: " + status + ", Date: " + orderDate + ", isPaid: " + isPaid;
    }
}