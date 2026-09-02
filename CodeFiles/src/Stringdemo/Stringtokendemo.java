package CodeFiles.src.Stringdemo;

import java.util.StringTokenizer;

public class Stringtokendemo
{
    static void main(String[] args)
    {
        String s = "Welcome to Anudip foundation";

        StringTokenizer st = new StringTokenizer(s);

        System.out.println(st);
        while(st.hasMoreTokens())
            System.out.println(st.nextToken());

//        System.out.println(st.nextToken());

        char ch[]={'h','e','l','l','o'};
        String s44=new String(ch);
        String ss= String.valueOf(ch);
    }
}
