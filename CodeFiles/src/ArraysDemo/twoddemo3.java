package CodeFiles.src.ArraysDemo;

import java.util.Scanner;

public class twoddemo3
{
    public static int[][] createArray(int rows, int cols)
    {
        Scanner sc=new Scanner(System.in);

        int x[][]=new int[rows][cols];
        for(int r=0;r<x.length;r++)
        {
            for(int c=0;c<x[r].length;c++)
            {
                System.out.print("Enter value : ");
                x[r][c]=sc.nextInt();
            }
        }
        return x;
    }
    public static void display(int x[][])
    {
        System.out.println("Array Elements : ");

        for(int r=0;r<x.length;r++) {
            for (int c = 0; c < x[r].length; c++) {
                System.out.print(x[r][c] + "\t");
            }
            System.out.println();
        }
    }
//    Write a method to add the elements of two arrays
//    the dimension of these two arrays must be same
//    return the sum array to the main and print the elements of sum array as well.
    public static int[][] sum(int[][] arr1, int[][] arr2)
    {
        if(arr1.length!=arr2.length || arr1[0].length!=arr2[0].length)
        {
            System.out.println("Unable to Add elements as dimensions are not same!!");
            return new int[][]{{-1,-1}};
        }
        int sum [][] = new int[arr1.length][arr1[0].length];
        int n = arr1.length;
        int m = arr1[0].length;
        for(int i = 0;i<n;i++){
            for (int j = 0;j<m;j++){
                sum[i][j] = arr1[i][j]+arr2[i][j];
            }
        }
        return sum;
    }
//    Write a method to subtract the elements of two arrays
//    the dimension of these two arrays must be same
//    return the sum array to the main and print the elements of sum array as well.

//    matrix multiplication
    public static int[][] multiplication(int a[][], int b[][])
    {
        if(a.length!=b[0].length)
        {
            System.out.println("Unable to Add elements as dimensions are not same!!");
            return new int[][]{{-1,-1}};
        }

        int multi[][]=new int[a.length][b[0].length];

        for(int r=0;r<a.length;r++)// 9 times
        {
            for(int c=0;c<a[r].length;c++)// 3 times
            {
                multi[r][c]=0;
                for(int m=0;m<a.length;m++)// every multi
                {
                    multi[r][c]+=a[r][m]*b[m][c];
                }
            }
        }
        return multi;
    }
    static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number or rows and columns : ");
//        create first array
        int a[][]= createArray(sc.nextInt(), sc.nextInt());
        System.out.print("Enter number or rows and columns : ");
        int b[][]=createArray(sc.nextInt(), sc.nextInt());

        display(a);
        display(b);

        int sum[][]=sum(a,b);
        System.out.println("Elements of Sum array : ");
        display(sum);

        int multi[][]=multiplication(a,b);
        System.out.println("Multiplication of Matrix: ");
        display(multi);
    }
}

