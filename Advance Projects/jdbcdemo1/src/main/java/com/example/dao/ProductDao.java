package com.example.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.utilites.DBConnection;

public class ProductDao 
{
    // db transactions
    Connection con;
    Statement st;
    ResultSet rs;

    public void showProducts()
    {
        String query = "select * from product";

        try
        {
            con= DBConnection.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);

            while(rs.next())
            {
                System.out.println("=================================");
                System.out.println("Product Id : "+rs.getInt(1));
                System.out.println("Product Name : "+rs.getString(2));
                System.out.println("Cost Price : "+rs.getFloat(3));
                System.out.println("Selling Price : "+rs.getFloat(4));
                System.out.println("Quantity : "+rs.getInt(5));
            }
            rs.close();
        }catch(SQLException ex)
        {
            System.out.println("Error : "+ex);
        }
    }
}
