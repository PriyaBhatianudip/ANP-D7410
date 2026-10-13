package com.example;

import com.example.dao.ProductDao;
import com.example.entities.Product;
import java.util.*;

/**
 * Hello world!
 */
public class App 
{
    Scanner sc;
    ProductDao pdao;
    App()
    {

        sc=new Scanner(System.in);
        pdao=new ProductDao();
    }

    public Product addNewProduct()
    {
        // treat this function product form
        Product p=new Product();
        System.out.println("Enter Product Id : ");
        p.setProductId(sc.nextInt());
        System.out.println("Enter Product Name : ");
        sc.nextLine();
        p.setProductName(sc.nextLine());
        System.out.println("Enter Cost Price : ");
        p.setCostPrice(sc.nextFloat());
        System.out.println("Enter SellingPrice : ");
        p.setSellingPrice(sc.nextFloat());
        System.out.println("Enter Quantity : ");
        p.setQty(sc.nextInt());
        
        return p;
    }
    public void searchProduct()
    {
        // acts as front end to get product description/name from the user
        System.out.println("Enter Product name : ");
        sc.nextLine();
        String productdetail = sc.nextLine();

        // now send this detail to the dao class
        List<Product> list = pdao.showProduct(productdetail);
        System.out.println("List : "+list);

        if(list.size()==0)
            System.out.println("Product Not Found!!");
        else
            for(Product p:list)
            {
                System.out.println("---------------------------------------");
                System.out.println("Product name : "+p.getProductName());
                System.out.println("Product price : "+p.getSellingPrice());
                System.out.println("Quantity : "+p.getQty());
                System.out.println("---------------------------------------");

            }
    }
    public void menu()
    {
        int choice;
        do {
            System.out.println("0. Exit");
            System.out.println("1. Show Records");
            System.out.println("2. Add new product");
            System.out.println("3. Update Product Info");
            System.out.println("4. Show Product");
            System.out.println("5. Delete a product");

            System.out.println("Enter your choice ");
            choice=sc.nextInt();

            if(choice==0) System.out.println("Goodbye!!");
            else if(choice ==1 )
            {
                List<Product> records = pdao.showProducts();

                records.stream().forEach(System.out::println);
            }
            else if(choice==2)
            {
                Product p= addNewProduct();
                pdao=new ProductDao();
                pdao.addProduct(p);
                System.out.println("Product Added Successfully!!");
            }
            else if (choice==4)
                searchProduct();
            else
                System.out.println("Wrong Choice!!");
        }while(choice!=0);
    }
    public static void main(String[] args) 
    {
        App app=new App();
        app.menu();
    }
}
