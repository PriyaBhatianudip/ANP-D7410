package CodeFiles.src.ArraysDemo;

import java.util.Scanner;

public class OneDArrayAssignment {
    int a[];
    Scanner sc;
    int index;

//constructor
    OneDArrayAssignment(int size)
    {
        a = new int[size];
        sc = new Scanner(System.in);
        index = -1;
    }

//    checks whether the array is empty
    public boolean isEmpty()
    {
        if(index==-1) return true;

        return false;
    }

    public boolean isFull()
    {
        if(index==a.length-1) return true;

        return false;
    }
//array[index=-1]     deletearray(array[index--]=0)  array[-1]=0, ArrayIndexOutOfBoundsException
//    create a function to insert a new value in array at the availableIndex
    public void insertEnd()
    {
        if(isFull())
            System.out.println("Array is Full!!Can't insert new value!!");
        else {
            System.out.println("Enter a new value : ");
            a[++index]=sc.nextInt();
            System.out.println("Value inserted successfully!!");
        }
    }
    public void display()
    {
        System.out.println("Array Elements are :-");
        for(int value:a) System.out.print(value+"\t");
        System.out.println("\n======================================");
    }
    public void rotateClockwise()
    {

    }
    public void rotateAntiClockwise()
    {

    }
    public void menu()
    {
        char ch;

        do {
            System.out.println("1. Insert at End");
            System.out.println("2. Display");
            System.out.println("3. Rotate Array");
            System.out.println("Enter your choice : ");
//            int choice=sc.nextInt()
            switch (sc.nextInt())
            {
                case 1:
                {
                    insertEnd();
                    break;
                }
                case 2: {
                    display();
                    break;
                }
                default:
                    System.out.println("Wrong choice!!");
            }

            System.out.println("Do You want to continue(y/n)");
            ch=sc.next().charAt(0);
        }while(ch=='y'||ch=='Y');
    }
    static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the size of array : ");
        OneDArrayAssignment oned=new OneDArrayAssignment(sc.nextInt());
       oned.menu();

    }
}
