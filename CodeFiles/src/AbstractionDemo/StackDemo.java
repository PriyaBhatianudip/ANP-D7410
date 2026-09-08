package CodeFiles.src.AbstractionDemo;

public interface StackDemo
{
    int SIZE=10;

    public void push(int value);
    public int pop();

    public boolean isEmpty();
    public boolean isFull();
    public void display();
}
