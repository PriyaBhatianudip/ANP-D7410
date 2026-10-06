package com.employeemgt.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection 
{
    // db connection related code
    // setup the objects

    private static final String url ="jdbc:mysql://localhost:3306/employeemanagement";
    private static final String username="root";
    private static final String password ="1234";

    public static Connection getConnection()
    {
        Connection con=null;
        try
        {
//        	it is sending url, username and password to the internal getConnection
//        	method. It will search and connect with the given url using given username and
//        	password.
            con =DriverManager.getConnection(url,username,password);
            System.out.println("DB Connected Successfully!!");
        }catch(SQLException se)
        {
            System.out.println("Database connection failed!!");
            System.out.println(se);
        }
        return con;
    }
}
