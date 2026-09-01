package CodeFiles.src.ArraysDemo;

import java.util.Scanner;

public class jaggedarraydemo {
    static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        String name[]=new String[5];
        long mobileno[][]=new long[5][];

        System.out.println("Provide Details here:-");
        for(int i=0;i< name.length;i++)
        {
            System.out.print("Enter Name : ");
            name[i]=sc.nextLine();

            System.out.print("Enter the number of mobile numbers");
            mobileno[i]=new long[sc.nextInt()];

            for(int c=0;c<mobileno[i].length;c++)
            {
                System.out.print("Enter Mobile Number : ");
                mobileno[i][c]=sc.nextLong();
            }
            sc.nextLine();
        }

        for(int r=0;r< name.length;r++) {
            System.out.print("Name : "+name[r]);
            System.out.print("\tMobile Number : ");
            for (int c = 0; c < mobileno[r].length; c++)
            {
                System.out.print(mobileno[r][c]+", ");
            }
            System.out.println();
        }

    }
}
