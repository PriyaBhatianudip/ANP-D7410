package CodeFiles.src.ExceptionDemo;

import java.util.Scanner;

public class arraydemo
{
    static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int a[]={923,219,91,209,2929,280,879};

//        input a position from user to search for a number
        System.out.println("Enter a position : ");
        int pos=sc.nextInt();
        pos--;

        if(pos>=0 &&  pos<a.length)
            System.out.println("Value at "+(pos+1)+" is "+a[pos]);
        else
            System.out.println("Position not found!!");

        try
        {
            System.out.println("Value : " + a[pos]);
        }catch(ArrayIndexOutOfBoundsException e)
        {
//            e.printStackTrace();
            System.out.println("Error : "+e);
            System.out.println("Please provide proper index!!");
        }

        System.out.println("Array operations finished");

    }
}
