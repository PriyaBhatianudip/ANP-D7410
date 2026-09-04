package CodeFiles.src.Stringdemo;

import java.util.Scanner;

public class wordcount
{
    static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter  a string : ");
        String str = sc.nextLine();

        int count=0;
        int i=0;
        while(str.charAt(i)==' ') i++;
        boolean flag=false;
        for(;i<str.length();i++)
        {
            if(str.charAt(i)  == ' ')
            {
                if(flag)
                {
                    continue;
                }
                count++;
                flag=true;
            }
            else flag=false;
        }
        if(!flag) count++;

        System.out.println("Number of words : "+count);

    }
}
