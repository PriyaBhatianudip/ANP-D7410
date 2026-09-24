package CodeFiles.src.collectiondemo;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentDemo
{
    static void main(String[] args) {
        ConcurrentHashMap<Integer, Integer> marks= new ConcurrentHashMap<>();

        System.out.println("Marks : "+marks);
        marks.put(101, 89);
        marks.put(102, 90);
        marks.put(103,88);
        marks.put(104, 69);
        marks.put(105, 70);
        marks.put(106,83);

//        to add 5 marks more into the marks values
        marks.compute(102,(key,value)-> value+5);

//        how to change marks of every student by adding 5 in each students marks value.
//        marks.forEach((key,value)->marks.compute(key,(k,v)-> v+5));
        marks.forEach((key, value)->marks.replace(key, value+5));
        marks.replaceAll((key,value)-> value+5);

        System.out.println("Marks : "+marks);
// we need to print all key value pairs one by one
        marks.forEach((key, value)->System.out.println(key + " : " + value));

//        print elements using stream()

        marks.entrySet().stream().forEach(
                e -> System.out.println("Roll No. :"+e.getKey()+
                        " , Marks : "+e.getValue()));
//        another way
        System.out.println("---------------------------------------");
        marks.entrySet().stream().forEach(System.out::println);
    }
}
