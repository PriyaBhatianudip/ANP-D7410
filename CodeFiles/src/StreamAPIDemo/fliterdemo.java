package CodeFiles.src.StreamAPIDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class fliterdemo
{
    static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of names to Store:");
        int n = sc.nextInt();

        sc.nextLine();

        while (n > 0) {
            System.out.println("Enter the Name:");
            list.add(sc.nextLine());
            n--;
        }

        list.stream()
                .filter(name -> name.startsWith("A"))
                .forEach(System.out::println);

        list.stream()
                .filter(name -> name.length()>5)
                .forEach(System.out::println);
//7. count the names which are starting with 'A'.
        long count= list.stream()
                .filter(name -> name.startsWith("A"))
                .count();

        System.out.println("Count of names starting with A : "+count);
        long c = list.stream().filter(s -> s.contains("s")).count();
        System.out.println("Count of Names having s : "+c);

        List<Integer> numbers = Arrays.asList(
                10, 25, 30, 45, 50, 65, 70, 85, 90
        );


    }
}
