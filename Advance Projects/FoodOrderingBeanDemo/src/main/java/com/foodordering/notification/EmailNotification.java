package com.foodordering.notification;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class EmailNotification implements Notifications 
{
	@Override
	public void sendNotification(String message) 
	{
		System.out.println("Email : "+message);
	}
}
