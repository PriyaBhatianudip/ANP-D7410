package com.foodordering.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.foodordering.model.Order;

@Repository
public class OrderRepository 
{
	private List<Order> orders = new ArrayList<>();
	
	public void saveOrder(Order order)
	{
		orders.add(order);
		System.out.println("Order Saved Successfully!!");
	}
	
	public void displayOrders()
	{
		if(orders.isEmpty())
			System.out.println("Order not Found!!");
		else 
		{
			for(Order order: orders)
			{
				System.out.println(order);
				System.out.println("--------------------------");
			}
		}
	}
}
