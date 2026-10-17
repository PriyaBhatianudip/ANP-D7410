package com.files;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.files.dao.ItemDao;
import com.files.entity.Item;



/**
 * Hello world!
 */
public class App 
{
Scanner sc;
	
	public App() 
	{
		sc = new Scanner(System.in);
	}
	public void addItem()
	{
		Item item = new Item();
		
		System.out.println("Enter item name : ");
		item.setItemName(sc.nextLine());
		
		System.out.println("Enter item type : ");
		item.setType(sc.nextLine());
		
		System.out.println("Enter count of Accessories : ");
		int n=sc.nextInt();
		
		ArrayList<String> accessories =new ArrayList<String>();
		sc.nextLine();
		
		while(n>0)
		{
			System.out.println("Enter accessory name : ");
			accessories.add(sc.nextLine());
			n--;
		}
		
		item.setAccessories(accessories);
		
//		add set
		Set<String> specs = new HashSet<String>();
		
		while(true)
		{
			System.out.println("Enter specifications : ");
			specs.add(sc.nextLine());
			
			System.out.println("Do you want to add more specifications(y/n) : ");
			
			char ch=sc.next().charAt(0);
			sc.nextLine();
			if(ch=='N' || ch=='n')
				break;
		}
		
		item.setSpecifications(specs);
		
		ItemDao dao=new ItemDao();
		dao.addItem(item);
		System.out.println("Item saved successfully!!");
	}
	
	public static void main(String[] args) 
	{
		App ob=new App();
		ob.addItem();
	}
}
