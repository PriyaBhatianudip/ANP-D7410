package LoopsDemo;

import java.util.Scanner;

public class pyramid {
    static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter number of rows : ");
        int rows=sc.nextInt();

        for(int r=1; r<=rows;r++) {// r=1 2 3
            for (int s = rows - 1; s >= r; s--)//4 3
                System.out.print(" ");
            for (int n = 1; n <= r; n++) // n=5 n<=5
            {
                if (n == 1 || n == r || r == rows)
                    System.out.print(r + " ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }

    }
}
