package com.files.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;
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
@Table(name = "item1")
public class Item 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="item_id")
	private int itemId;
	
	@Column(name="item_name", nullable = true)
	private String itemName;
	private String type;
	
	@ElementCollection
	@CollectionTable(name="accessories1", joinColumns = @JoinColumn(name="i_id"))
	@Column(name="accessory")
	@OrderColumn(name="accessory_index")
	private List<String> accessories;
	
	@ElementCollection
	@CollectionTable(name="specs1", joinColumns = @JoinColumn(name="item_id"))
	@Column(name="specs")
	private Set<String> specifications= new HashSet<String>();
}
