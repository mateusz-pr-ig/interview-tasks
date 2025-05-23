package com.jmatt.interview.task4;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OrderServiceTest {

    @Test
    void orderServiceSetsStatusToReservedWhenOrderIsNotFullyPaid() {
        Order order = new Order();
        OrderItem orderItem = new OrderItem();
        orderItem.setPrice(10.12);
        order.setOrderItems(List.of(orderItem));
        OrderStatus reserved = new OrderStatus();
        reserved.setStatusId(1);

        Order result = order.reserveAndPayForOrder(order, 9.99);

        assertThat(result.getStatus()).isEqualTo(reserved);
    }

    @Test
    void orderServiceSetsStatusToPaidWhenOrderIsPaid() {
        Order order = new Order();
        OrderItem orderItem = new OrderItem();
        orderItem.setPrice(10.12);
        order.setOrderItems(List.of(orderItem));
        OrderStatus paidOrderStatus = new OrderStatus();
        paidOrderStatus.setStatusId(2);

        Order result = order.reserveAndPayForOrder(order, 10.12);

        assertThat(result.getStatus()).isEqualTo(paidOrderStatus);
    }

    @Test
    void orderServiceSetsStatusToPaidWhenOrderIsPaidWhenQuantityBiggerThen1() {
        Order order = new Order();
        OrderItem orderItem = new OrderItem();
        orderItem.setPrice(10.4);
        orderItem.setQuantity(2);
        order.setOrderItems(List.of(orderItem));
        OrderStatus paidOrderStatus = new OrderStatus();
        paidOrderStatus.setStatusId(2);

        Order result = order.reserveAndPayForOrder(order, 10.4);

        assertThat(result.getStatus()).isEqualTo(paidOrderStatus);
        //assertThat(order.getTotalPrice()).isEqualTo(20.8);
    }
}