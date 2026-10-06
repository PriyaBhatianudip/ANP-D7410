package com.employeemgt;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) 
    {
        System.out.println("Welcome to Employee Management System");
        System.out.println("--------------------------------------");
        
        EmpMenu empmenu=new EmpMenu();
        empmenu.menu();
    }
}
