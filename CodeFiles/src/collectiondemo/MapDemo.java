package CodeFiles.src.collectiondemo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class MapDemo
{
    static void main(String[] args) {
        HashMap<Integer, String> list = new HashMap<>();

        list.put(101, "Anas");
        list.put(102,"Ashish");
        list.put(103, "Aryan");
        list.put(104,"Dev");

        System.out.println("values : "+list);

//        to get all the keys
        Set<Integer> keys = list.keySet();

//        to print all values using keys
        keys.stream().forEach(x->System.out.println(x+" : "+list.get(x)));
//     101, 102, 103, 104
//           x
//     Anas, Ashish
//        using lambda

        System.out.println("using lambda");
        list.forEach((key, value)-> System.out.println(key+" : "+value));

//        keys.get().stream().forEach(System.out::println);

//        to get all the values
        Collection<String> values=  list.values();

        values.forEach(System.out::println);


    }
}
