package com.foodordering.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer 
{
	private String cutomerName;
	private int customerId;
	private String email;
	@Override
	public String toString() 
	{
		return "Customer Id : "+customerId
				+"\nCustomer Name : "+cutomerName
				+"\nEmail Id : "+email;
	}
	
	
}
