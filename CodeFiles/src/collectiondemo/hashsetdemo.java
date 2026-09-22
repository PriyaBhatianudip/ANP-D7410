package CodeFiles.src.collectiondemo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class hashsetdemo
{
    static void main(String[] args) {
        Set<Integer> values = new HashSet<Integer>();
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter number of elements : ");
        int n=sc.nextInt();

        while(n>0)
        {
            System.out.println("Enter a value : ");
            values.add(sc.nextInt());
            n--;
        }
        System.out.println("Hash set values : "+values);

//        convert this hashset into an array of int type

//        Object[] obarray = values.toArray();
//
//        int arr[] = Arrays.stream(obarray)
//                .mapToInt(x->(Integer)x)
//                .toArray();


        int arr[] = Arrays.stream(values.toArray()).mapToInt(x->(Integer)x)
                .toArray();

        Arrays.stream(arr).forEach(System.out::println);
    }
}
