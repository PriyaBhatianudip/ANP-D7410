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
//        to iterator over the list elements
        Iterator<Integer> itr = list.iterator();// it will store all the elements of the list into itr object
        while(itr.hasNext())
            System.out.println(itr.next());
    }
}
//itr =
//        i
//itr.hasNext() :  it checks whether we have next element in itr object or not and returns true or false.
//next(): it will return the current value in itr object and then it removes that value from object.
// 34  56  888 56