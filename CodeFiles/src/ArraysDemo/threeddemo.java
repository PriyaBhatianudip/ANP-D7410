package CodeFiles.src.ArraysDemo;

import java.util.Scanner;

public class threeddemo
{
    static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int a[][][]=new int[3][3][2];

        for(int t=0;t<a.length;t++)
        {
            System.out.println("Table : "+(t+1));
            for(int r=0;r<a[t].length;r++)
            {
                for(int c=0;c<a[t][r].length;c++)
                {
                    System.out.println("Enter value : ");
                    a[t][r][c]=sc.nextInt();
                }
            }
        }

//        display elements
        for(int t=0;t<a.length;t++) {
            System.out.println("Table : " + (t + 1));
            for (int r = 0; r < a[t].length; r++) {
                for (int c = 0; c < a[t][r].length; c++) {
                    System.out.print(a[t][r][c] + "\t");
                }
                System.out.println();
            }
            System.out.println("-----------------------------------------");
        }
    }

}
