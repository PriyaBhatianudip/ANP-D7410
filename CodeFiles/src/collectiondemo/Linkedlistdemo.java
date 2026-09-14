package CodeFiles.src.collectiondemo;

import java.util.Iterator;
import java.util.LinkedList;

public class Linkedlistdemo {
    static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        System.out.println("size : "+list.size());
        list.add(34);
        list.add(56);
        list.add(88);
        list.add(56);
        System.out.println("size : "+list.size());
        System.out.println(list);

//    display elements using for each loop
        for (Integer var : list) {
            System.out.println(var);
        }

        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext())
            System.out.println(itr.next());

    }
}
