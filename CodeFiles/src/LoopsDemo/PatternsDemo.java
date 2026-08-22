package LoopsDemo;

import java.util.Scanner;

public class PatternsDemo
{
    public void pyramid1(int rows)
    {
        System.out.println("---------------Pyramid 1---------------");
        for(int r=1;r<=rows;r++)
        {
            for(int c=1;c<=r;c++)
            {
                System.out.print(r);
            }
            System.out.println();
        }
        System.out.println("----------------------------------------------");
    }

    public void pyramid2(int rows)
    {
        System.out.println("---------------Pyramid 2---------------");
        for(int r=1;r<=rows;r++)// 5 times r=1 , 2, 3 , 4, 5  4<=5 true
        {
            for(int c=1;c<=r;c++)// c=1   1<=5  true
            {
                System.out.print(c);// 1234
            }
            System.out.println();
        }
        System.out.println("----------------------------------------------");
    }

    public void pyramid5(int rows)
    {
        System.out.println("---------------Pyramid 5---------------");
        for(int r=1;r<=rows;r++)// to run rows
        {
            for(int s=rows;s>r;s--)// // print space
            {// 4 to 1, 4 to 2, 4 to 3, 4 to 4
                System.out.print(" ");
            }
            for(int c=1;c<=r;c++) // print numbers
            {
                System.out.print(c);
            }
            System.out.println();
        }
        System.out.println("----------------------------------------------");
    }

    public void menu()
    {
        Scanner sc=new Scanner(System.in);

        int choice;
        do
        {
            System.out.println("0. Exit");
            System.out.println("1. Pyramid 1");
            System.out.println("2. Pyramid 2");
            System.out.println("5. Pyramid 5");

            System.out.println("Enter your choice : ");
            choice=sc.nextInt();

            if(choice==0) System.out.println("GoodBye");
            else {
                System.out.println("Enter number of rows : ");
                int rows=sc.nextInt();

                if (choice == 1) pyramid1(rows);
                else if(choice==2) pyramid2(rows);
                else if(choice==5) pyramid5(rows);
                else System.out.println("Wrong Choice!! Try Again!!");
            }
        }while(choice!=0);
    }
    static void main(String[] args) {
        PatternsDemo pd=new PatternsDemo();
        pd.menu();
    }
}
