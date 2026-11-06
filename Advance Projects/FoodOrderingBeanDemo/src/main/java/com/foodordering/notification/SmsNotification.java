package com.foodordering.notification;

import org.springframework.stereotype.Component;

@Component
public class SmsNotification implements Notifications {

	@Override
	public void sendNotification(String message) {
		System.out.println("SMS : "+message);
		
	}

}
