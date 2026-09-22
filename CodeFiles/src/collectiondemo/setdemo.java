package CodeFiles.src.collectiondemo;

import java.util.HashSet;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;

public class setdemo
{
    static void main(String[] args) {

        TreeSet<Integer> set1 = new TreeSet<>();

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter number of elements : ");
        int n=sc.nextInt();

        while(n>0)
        {
            System.out.println("Enter a value : ");
            set1.add(sc.nextInt());
            n--;
        }
        System.out.println("Tree set values : "+set1);

        NavigableSet<Integer> set2 = set1.descendingSet();

        System.out.println("set in descending order : "+set2);

//        headset(), tailset()
        System.out.println("Head set : "+set1.headSet(50));
        System.out.println("Tail set : "+set1.tailSet(50));
    }
}
