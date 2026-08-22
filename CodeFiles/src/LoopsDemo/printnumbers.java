package LoopsDemo;

import java.util.Scanner;

public class printnumbers {
    static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

//        count number of digits
        System.out.println("Enter a number : ");
        int n=sc.nextInt();

        int count =0;
        while(n>0)
        {
            count++;
            n/=10;
        }
        System.out.println("Number of Digits : "+count);
    }
}
