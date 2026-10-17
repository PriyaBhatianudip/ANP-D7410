package com.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
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
//  this is an entity class which will be mapped with the table in the database
public class Item 
{
	private int itemId;
	private String itemName;
	private String type;
	private List<String> accessories;
	private Set<String> specifications= new HashSet<String>();
}
