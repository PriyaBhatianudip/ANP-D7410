package Datatypesdemo;
import java.util.Scanner;
public class chardemo
{
    static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        System.out.print("Enter a character : ");
        char ch =  sc.next().charAt(0); // ch =    buffer = 'kdkdkkf".charAt(0) = ch=k
        System.out.println("Character : "+ch);

//        determine whether it is in capital case or lower case
//        (ch>='A' && ch<='Z') -> capital
        System.out.println(ch>='A' && ch<='Z'?ch+" is in capital case.": ch+" is in lower case.");
    }
}
