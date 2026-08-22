package ArraysDemo;

import java.util.Scanner;

public class onedarray
{
    static void main(String[] args) {
        int id[]={101,102,103,104,105};

        String names[]=new String[id.length];
        float salary[]=new float[id.length];

        Scanner sc=new Scanner(System.in);

        for(int i=0;i<id.length;i++)
        {
            System.out.println("Press enter to Input Records...");
            sc.nextLine();
            System.out.println("Id : "+id[i]);
            System.out.print("Enter Name : ");
            names[i]=sc.nextLine();

            System.out.print("Enter Salary : ");
            salary[i]=sc.nextFloat();// \0
        }

//        display elements
//        print names

//        System.out.println("Employee Names");
//        for(String nm: names)
//        {
//            System.out.println(nm);
//        }

        System.out.println("Employee Records");
        System.out.println("Id\tName\tSalary");
        for(int i=0;i<id.length;i++)
        {
            System.out.println(id[i]+"\t"+names[i]+"\t"+salary[i]);
        }
    }
}
