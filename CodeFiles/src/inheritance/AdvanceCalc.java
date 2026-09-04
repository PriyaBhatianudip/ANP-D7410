package CodeFiles.src.inheritance;

import java.util.Scanner;

public final class AdvanceCalc extends Calculator
{
    public void areaRectangle(int length, int width)
    {
        System.out.println("Area of Rectangle : "+(length*width));
    }

    public void areaCircle(double radius)
    {
        System.out.println("Circle Area : "+(3.14*radius*radius));
    }

//    method overriding
    public void add(int a, int b)
    {
        int c=24;
        System.out.println("Sum : "+(a+b+c));
    }

    public void addition()
    {
        Scanner sc=new Scanner(System.in);

        System.out.println("Input A for 2 value addition\nInput B for 3 value addition");
        char ch= sc.next().charAt(0);

        if(ch=='A' || ch=='a')
        {
            super.add(23,55);// calls parent class method
        }
        else
        {
            add(45,89);// calls child class method
        }
    }
//    public final void areaSquare(int side)
//    {
//        System.out.println("Area of Square : "+(side*side));
//    }
}
