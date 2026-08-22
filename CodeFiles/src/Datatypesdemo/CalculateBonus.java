package Datatypesdemo;

import java.util.Scanner;

public class CalculateBonus
{
    static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        System.out.print("Enter Salary :  ");
        double salary = sc.nextDouble();

        System.out.println("Enter Experience : ");
        int exp = sc.nextInt();

        System.out.println("Salary : "+salary);
        System.out.println("Experience : "+exp);

//        calculate bonus if exp>=20,   20%,  exp<20 -> 10%

        double bonus = exp >= 20 ? salary*0.20 : salary*0.10;

        System.out.println("Bonus : "+bonus);
    }
}
