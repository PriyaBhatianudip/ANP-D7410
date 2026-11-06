package com.foodordering.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

	private int orderId;
	private String customerName;
	private String foodName;
	private double amount;
	
	@Override
	public String toString() 
	{
		return "Order Id : "+orderId
				+"\nCustomer Name : "+customerName
				+"\nFood Name : "+foodName
				+"\nTotal Amount : "+amount;
	}

	public void setOrderDetails(int orderId, String customerName, String foodName, double price) {
		this.orderId = orderId;
		this.customerName=customerName;
		this.foodName=foodName;
		this.amount=price;
		
	}
}