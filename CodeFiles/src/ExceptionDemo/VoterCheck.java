package CodeFiles.src.ExceptionDemo;

import java.util.Scanner;

public class VoterCheck
{
    static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter Age : ");
        int age=sc.nextInt();

        try
        {
            if(age>=18) System.out.println("You are eligible to vote!!");
            else throw new AgeCheckerException("Age must be greater than or equals to 18 to Vote!!");

        }catch(AgeCheckerException ae)
        {
            System.out.println("Error : "+ae.getMessage());
        }

    }
}
