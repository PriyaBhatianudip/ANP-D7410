package CodeFiles.src.Stringdemo;

import java.util.Scanner;

public class Stringdemo
{
    static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        String s1 ="Hello";
        String s2 ="Hello";

        String s3 = "Java";
        String ss=new String();
        String s4=new String("Delhi");
        String s5 = new String("Delhi");

        if(s1 == s2) {
            System.out.println("Both have same references");
            System.out.println("s1 : " + System.identityHashCode(s1));
            System.out.println("s2 : " + System.identityHashCode(s2));
        }
        if(s1 == s3) {
            System.out.println("Both have same references");
            System.out.println("s1 : " + System.identityHashCode(s1));
            System.out.println("s3 : " + System.identityHashCode(s3));
        }
        else
        {
            System.out.println("Both have different references");
            System.out.println("s1 : " + System.identityHashCode(s1));
            System.out.println("s3 : " + System.identityHashCode(s3));
        }
        if(s4 == s5) {
            System.out.println("Both have same references");
            System.out.println("s4 : " + System.identityHashCode(s4));
            System.out.println("s5 : " + System.identityHashCode(s5));
        }
        else
        {
            System.out.println("Both have different references");
            System.out.println("s4 : " + System.identityHashCode(s4));
            System.out.println("s5 : " + System.identityHashCode(s5));
        }
    }
}
