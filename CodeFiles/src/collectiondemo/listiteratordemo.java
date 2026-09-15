package CodeFiles.src.collectiondemo;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Vector;

public class listiteratordemo
{
    static void main(String[] args) {
        ArrayList<String> names = new ArrayList<String>();

        Scanner sc=new Scanner(System.in);

//        get the number of names from user
        System.out.print("Enter number of names : ");
        int n=sc.nextInt();//  \0
        sc.nextLine();// it clears the buffer/ it inputs the value from buffer

        while(n>0)
        {
            System.out.print("Enter name : ");
            names.add(sc.nextLine());
            n--;
        }
        System.out.println("List of Names : "+names);

        ListIterator<String> itr= names.listIterator();

        System.out.println("List Elements :-");
//        traverse list elements one by one
        while(itr.hasNext())
        {
            System.out.println(itr.next());
        }

//        traverse in backwards/reverse order
        System.out.println("Elements in reverse order");
        while(itr.hasPrevious())
        {
            System.out.println(itr.previous());
        }
//        System.out.println(itr.previous());
//        add a new elements
        itr.add("Robin");
        itr.add("Danish");

        System.out.println("Original list after adding two new names in the itrerator object: \n"+ names);
        System.out.println("Iterator object names : "+itr);

        itr.next();
        itr.remove();
        System.out.println("Original list after removing a name in the itrerator object: \n"+ names);

        String nm = itr.previous();
        System.out.println("Name at previous : "+nm);
        itr.set("abcd");
        System.out.println("names : "+names);

    }
}
// names=  aa bbb
// names object =  xy123
// listiterator ob =  xy123