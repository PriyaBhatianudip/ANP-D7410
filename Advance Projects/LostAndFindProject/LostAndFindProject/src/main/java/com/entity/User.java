package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
public class User {

	private int id;
	private String name;
	private double phone;
	private String email;
	private String password;
	private String address;
	private String department;
}
