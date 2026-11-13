package com.foodordering.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

import com.foodordering.model.FoodItem;
import com.foodordering.model.Order;
import com.foodordering.notification.Notifications;
import com.foodordering.repository.OrderRepository;

@Service
public class OrderService {

    private final FoodService foodService;
    private final OrderRepository orderRepository;
    private final PaymentService paymentService;
    private final List<Notifications> notifications;
    private final ObjectProvider<Order> orderProvider;

    public OrderService(
            FoodService foodService,
            OrderRepository orderRepository,
            PaymentService paymentService,
            List<Notifications> notifications,
            ObjectProvider<Order> orderProvider) {

        this.foodService = foodService;
        this.orderRepository = orderRepository;
        this.paymentService = paymentService;
        this.notifications = notifications;
        this.orderProvider = orderProvider;
    }

    public void placeOrder(int orderId, String customerName,
                           int foodId) {

        FoodItem food = foodService.getFoodItem(foodId);

        if (food == null) {
            System.out.println("Invalid food item!");
            return;
        }

        // Obtain a fresh Prototype bean
        Order order = orderProvider.getObject();

        order.setOrderDetails(
            orderId,
            customerName,
            food.getFoodName(),
            food.getPrice()
        );

        System.out.println("\nOrder Details");
        System.out.println("--------------------");
        System.out.println(order);

        // Save order
        orderRepository.saveOrder(order);

        // Process payment
        paymentService.processPayment(food.getPrice());

        // Send notifications through all channels
        String message = "Your order " + orderId
                + " has been placed successfully.";

        for (Notifications notification : notifications) {
            notification.sendNotification(message);
        }
    }

    public void displayAllOrders() {
        orderRepository.displayOrders();
    }
}