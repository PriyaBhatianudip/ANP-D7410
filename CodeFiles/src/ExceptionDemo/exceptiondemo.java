package CodeFiles.src.ExceptionDemo;
import java.util.Scanner;
public class exceptiondemo
{
    static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter two numbers : ");
        int a =sc.nextInt();
        int b=sc.nextInt();
        System.out.println("Sum : "+(a+b));
        System.out.println("Difference : "+(a-b));
        System.out.println("Product : "+(a*b));
        try
        {
            System.out.println("Division : " + (a / b));
            System.out.println("Modulus : " + (a % b));
        }catch (ArithmeticException ae)
        {
            System.out.println("Error : "+ae.getMessage());
        }
        System.out.println("Goodbye!!");
    }
}
