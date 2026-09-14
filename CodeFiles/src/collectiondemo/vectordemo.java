package CodeFiles.src.collectiondemo;

import java.util.Vector;

public class vectordemo
{
    static void main(String[] args) {
        Vector<Integer> list1 =new Vector<>(5);
        Vector<Integer> list2=new Vector<>();
        Vector<Integer> list3 =new Vector<>(5,2);

        System.out.println("Capacity of List 1: "+list1.capacity());
        System.out.println("Capacity of List 2: "+list2.capacity());
        System.out.println("Capacity of List 3: "+list3.capacity());

        for(int i=101;i<=106;i++)
        {
            list1.add(i);
            list2.add(i);
            list3.add(i);

        }
        System.out.println("Capacity of List 1: "+list1.capacity());
        System.out.println("Capacity of List 2: "+list2.capacity());
        System.out.println("Capacity of List 3: "+list3.capacity());
    }
}
