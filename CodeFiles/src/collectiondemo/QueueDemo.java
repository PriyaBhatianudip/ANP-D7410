package CodeFiles.src.collectiondemo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class QueueDemo
{
    static void main(String[] args)
    {
//        Deque<Integer> queue= new ArrayDeque<Integer>();
        ArrayDeque<Integer> queue= new ArrayDeque<Integer>();
        queue.add(89);
        queue.add(90);
        queue.add(101);
        queue.add(122);
        queue.add(145);
        System.out.println("Queue : "+queue);

        System.out.println(queue.remove());
        System.out.println("Queue : "+queue);

        queue.addFirst(78);
        queue.addLast(777);
        System.out.println("Queue : "+queue);

        Integer i = queue.removeLast();
        System.out.println(i);
        System.out.println("Queue : "+queue);

//        removeIf(): removes elements which satisfies the given condition
//        syntax :  ob.removeIf(var -> condition);

        queue.removeIf(num -> num%2==0);

        System.out.println("Queue : "+queue);
        System.out.println("peek : "+queue.peek());
        System.out.println("Queue after peek : "+queue);

//        System.out.println("Queue : "+queue);
        System.out.println("poll : "+queue.poll());
        System.out.println("Queue after poll : "+queue);

    }
}
