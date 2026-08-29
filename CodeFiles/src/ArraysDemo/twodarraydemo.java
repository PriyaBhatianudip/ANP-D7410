package CodeFiles.src.ArraysDemo;

import java.util.Scanner;

public class twodarraydemo
{
    static void main(String[] args) {
        int a[][]=new int[3][4];

        Scanner sc =new Scanner(System.in);
//        a.length : in two-d, it returns number of rows
//        a[rowindex].length : it returns number of columns

        for(int r=0;r<a.length;r++)
        {
            for(int c=0;c<a[r].length;c++)
            {
                System.out.println("Enter value : ");
                a[r][c]=sc.nextInt();
            }
        }
        System.out.println("Array Elements : ");

        for(int r=0;r<a.length;r++) {
            for (int c = 0; c < a[r].length; c++) {
                System.out.print(a[r][c] + "\t");
            }
            System.out.println();
        }
    }
}
