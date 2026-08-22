package OOPs;

public class Oopsdemo
{
    int a=10;
    String name="abc";

    public Oopsdemo()
    {
        System.out.println("Object is being initialized...");
    }
    public void display()
    {
        System.out.println("a : "+a);
        System.out.println("name : "+name);
    }

    static void main(String[] args) {
        Oopsdemo ob1 =new Oopsdemo();
        Oopsdemo ob2 = new Oopsdemo();
        System.out.println("Objects created successfully!!");
        ob1.a=100;
        ob2.a=200;
        ob1.display();
        ob2.display();
    }
}
