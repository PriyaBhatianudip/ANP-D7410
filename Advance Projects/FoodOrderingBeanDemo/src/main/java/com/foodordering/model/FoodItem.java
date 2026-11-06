package com.foodordering.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoodItem {

	private int foodId;
	private String foodName;
	private double price;
	
	@Override
	public String toString() 
	{
		return "Food Item Id : "+foodId
				+"\nFood Item Name : "+foodName
				+"\nPrice : "+price;
	}
}