package LoopsDemo;

import java.util.Scanner;

public class reversedemo {
    static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

//        count number of digits
        System.out.println("Enter a number : ");
        int n=sc.nextInt();
        int rev=0;

        for(int x=n;x>0;x/=10)
        {
            int m= x%10;   // m= 12345%10=5
            rev= rev*10+m;
        }
        System.out.println("The reverse of "+n+" is "+rev);

        String str="java Programming";
        int len = str.length();
        System.out.println("The length of string : "+len);
        System.err.print("\'Welcome to Java\'\nHello how are you\t\tObject oriented programming");
    }
}
