package CodeFiles.src.collectiondemo;

import java.util.ArrayList;
import java.util.Iterator;

public class collectiondemo
{
    static void main(String[] args) {
        ArrayList<Integer> list= new ArrayList<>();

        list.add(34);
        list.add(56);
        list.add(88);
        list.add(56);

        System.out.println(list);

//    display elements using for each loop
        for(Integer var:list)
        {
            System.out.println(var);
        }

        Iterator<Integer> itr = list.iterator();
        while(itr.hasNext())
            System.out.println(itr.next());
    }
}
