package CodeFiles.src.inheritance;


class A
{
    A()
    {
        System.out.println("A Class Constructor");
    }
}

class B extends A
{
    B()
    {
        System.out.println("B class Constructor");
    }
}

class C extends B
{
    C()
    {
        System.out.println("C Class Constructor");
    }
}
public class constdemo
{
    static void main(String[] args) {
        C c=new C();
    }
}
