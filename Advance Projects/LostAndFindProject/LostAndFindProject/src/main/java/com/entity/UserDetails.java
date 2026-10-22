package com.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
//@ToString
@AllArgsConstructor
public class UserDetails
{
	private int userid;
	private String name;
	private String email;
	private long phone;
	
	private Department department;

	public UserDetails(String name, String email, long phone) 
	{
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "UserDetails [userid=" + userid + ", name=" + name + ", email=" + email + ", phone=" + phone
				+ ", department=" + department + "]";
	}
	
	
}
