package CodeFiles.src.AbstractionDemo;

import java.util.Scanner;

public class Stacksdemo implements StackDemo
{
    int stack[];
    Scanner sc;
    int top;

    public Stacksdemo()
    {
        stack=new int[SIZE];
        sc=new Scanner(System.in);
        top=-1;
    }

    @Override
    public void push(int value)
    {
//        it will check if the stack is full or not
//        if stack is not full, then it will add the new value next available index.
//        if stack is full, then it will print the error message and exit.
    }

    @Override
    public int pop() {
//        it will check if the stack is empty or not
//        if it is empty, then print the error message and return 0
//         otherwise, it will remove the last element from stack and then return it to the caller
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void display() {

    }

    public void menu()
    {

    }
}
