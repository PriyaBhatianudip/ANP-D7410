package com.example.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.entities.Product;
import com.example.utilites.DBConnection;

public class ProductDao 
{
    // db transactions
//   All these are inbuilt interfaces of java
    Connection con;    // it helps in connecting with database
    Statement st;  // it helps us to execute sql queries
    ResultSet rs;  // it stores results of sql queries

    public ProductDao()
    {
        con= DBConnection.getConnection();  // getConnection method is used for connecting with database
    }
    public List<Product> showProducts()
    {
        String query = "select * from product";

        List<Product> productrecords = null;

        try
        {
            con= DBConnection.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);

            productrecords = new ArrayList<Product>();
            while(rs.next())
            {
                // System.out.println("=================================");
                // System.out.println("Product Id : "+rs.getInt(1));
                // System.out.println("Product Name : "+rs.getString(2));
                // System.out.println("Cost Price : "+rs.getFloat(3));
                // System.out.println("Selling Price : "+rs.getFloat(4));
                // System.out.println("Quantity : "+rs.getInt(5));

                Product p=new Product();
                p.setProductId(rs.getInt(1));
                p.setProductName(rs.getString(2));
                p.setCostPrice(rs.getFloat(3));
                p.setSellingPrice(rs.getFloat(4));
                p.setQty(rs.getInt(5));

                productrecords.add(p);
            }
            rs.close();
         
            
        }catch(SQLException ex)
        {
            System.out.println("Error : "+ex);
        }
        return productrecords;
    }

    public int addProduct(Product p)
    {
        int status =0 ;
        String query = "insert into product values("
                +p.getProductId()
                +",'"+p.getProductName()+"',"
                +p.getCostPrice()+","
                +p.getSellingPrice()+","
                +p.getQty()+
                ")";
        try
        {
            st = con.createStatement();
            status = st.executeUpdate(query);

        }catch(SQLException se)
        {
            System.out.println("Error : "+se);
        }
        return status;
    }

    public List<Product> showProduct(String productdetail) 
    {
        String query = "select * from product where productName like '%"+productdetail+"%'";
        List<Product> productlist=null;
        try 
        {
            st = con.createStatement();
            rs= st.executeQuery(query);

            productlist=new ArrayList<Product>();

           while(rs.next())
            {
                Product p=new Product();
                p.setProductId(rs.getInt(1));
                p.setProductName(rs.getString(2));
                p.setCostPrice(rs.getFloat(3));
                p.setSellingPrice(rs.getFloat(4));
                p.setQty(rs.getInt(5));

                productlist.add(p);
            }

           
        } catch (SQLException ex) {
            System.getLogger(ProductDao.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    return productlist;
    }
}
