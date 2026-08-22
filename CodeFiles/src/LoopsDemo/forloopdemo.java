package LoopsDemo;

import java.util.Scanner;

public class forloopdemo
{
    static void main(String[] args)
    {
        System.out.println("Numbers from 1 to 10");
        for(int i=1;i<=10;i++) System.out.println(i);

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number : ");
        int n=sc.nextInt();

        System.out.println("Table of "+n);
        for(int i=1;i<=10;i++) System.out.println(n*i);

        for(int j=1;;j++) System.out.println("hello");


    }
}
