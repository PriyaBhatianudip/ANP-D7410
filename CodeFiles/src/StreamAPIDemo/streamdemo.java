package CodeFiles.src.StreamAPIDemo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class streamdemo
{
    static void main(String[] args)
    {
        ArrayList<Integer>  nums = new ArrayList<Integer>();
        ArrayList<Integer>  nums1=null;
        System.out.println("List : "+nums);

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of elements : ");
        int n=sc.nextInt();
        while(n>0)
        {
            System.out.println("Enter value : ");
            nums.add(sc.nextInt());
            n--;
        }
        System.out.println("Size : "+nums.size());
        System.out.println("List : "+nums);
//        apply stream api
        nums.stream().filter(x-> x>=50).forEach(System.out::println);
        System.out.println("Even Numbers : ");
        nums.stream().filter(x-> x%2==0).forEach(System.out::println);

        nums.stream().map(x-> x*x).forEach(System.out::println);
        nums.stream().map(x->x+x*0.1).forEach(System.out::println);

        System.out.println("Elements in Ascending order : ");
        nums.stream().sorted().forEach(System.out::println);

        System.out.println("Elements in Descending order : ");
        nums.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        System.out.println("Elements in Ascending order : ");
        nums.stream().sorted().limit(2).forEach(System.out::println);

        System.out.println("Top 2 : ");
        nums.stream().sorted(Comparator.reverseOrder()).limit(2).forEach(System.out::println);

       int max = nums.stream().max(Integer::compare).get();

        System.out.println("max value : "+max);

        System.out.println("Total values : "+ nums.stream().count());


    }
}
