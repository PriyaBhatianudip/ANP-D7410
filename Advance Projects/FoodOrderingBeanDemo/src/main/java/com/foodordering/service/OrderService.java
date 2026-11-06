package com.foodordering.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

import com.foodordering.model.FoodItem;
import com.foodordering.model.Order;
import com.foodordering.notification.Notifications;
import com.foodordering.repository.OrderRepository;


@Service
public class OrderService 
{
	private FoodService foodService;
	private OrderRepository orderRepository;
	private PaymentService paymentService;
	private final List<Notifications> notification;
	private final ObjectProvider<Order> orderProvider;
	
	public OrderService(FoodService foodService, OrderRepository orderRepository, PaymentService paymentService,
			List<Notifications> notification, ObjectProvider<Order> orderProvider) {
		this.foodService = foodService;
		this.orderRepository = orderRepository;
		this.paymentService = paymentService;
		this.notification = notification;
		this.orderProvider = orderProvider;
	}
	

	public void placeOrder(int orderId, String customerName, int foodId)
	{
		FoodItem food = foodService.getFoodItem(foodId);
		
		if(food == null)
		{
			System.out.println("Invalid Food Item");
			return;
		}
		
//		it is obtaining a fresh prototype bean
		Order order = orderProvider.getObject();
		
		order.setOrderDetails(orderId, customerName, food.getFoodName(), food.getPrice());
		
		System.out.println("Order Details Saved successfully!!");
		System.out.println(order);
		
//		payment
		paymentService.processPayment(food.getPrice());
		
//		send notification
		String message = "Your order "+orderId+" has been placed successfully!!";
		
		for(Notifications note : notification)
		{
			note.sendNotification(message);
		}
	}
	
	
	
	
	
}
