package Datatypesdemo;

import java.util.Scanner;

public class LoginDemo
{
    static void main(String[] args)
    {
        String userid ="abc@gmail.com";
        String password = "abc@123";
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter User Id : ");
        String uid =sc.nextLine();
        if(userid.equalsIgnoreCase(uid))
        {
            System.out.println("User id Found!!");
            System.out.println("Enter Password : ");
            String passwd = sc.nextLine();
            if(password.equals(passwd))
            {
                System.out.println("Login Successfull!!");
            }
            else
            {
                System.out.println("Incorrect Password!!");
            }
        }
        else
        {
            System.out.println("User Id Not Found!!");
        }
    }
}
