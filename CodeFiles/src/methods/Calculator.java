package methods;

public class Calculator
{
    public void add(int a, int b)
    {
        System.out.println("Sum : "+(a+b));
    }

    public void add(float a, float b)
    {
        System.out.println("Sum : "+(a+b));
    }

    public void add(double a, double b)
    {
        System.out.println("Sum : "+(a+b));
    }
    public void add(int arr[])
    {
        int sum=0;
        for(int n:arr)
            sum+=n;

        System.out.println("Sum : "+sum);
    }

}
