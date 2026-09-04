package CodeFiles.src.inheritance;

public class Calculator
{
    public void add(int a, int b)
    {
        System.out.println("Sum : "+(a+b));
    }

    public void sub(int a, int b)
    {
        System.out.println("Difference : "+(a-b));
    }
    public void multi(int a, int b)
    {
        System.out.println("Product : "+(a*b));
    }

    public void diff(int a, int b)
    {
        System.out.println("Division : "+(a/b));
    }

    public final void areaSquare(int side)
    {
        System.out.println("Area of Square : "+(side*side));
    }
}
