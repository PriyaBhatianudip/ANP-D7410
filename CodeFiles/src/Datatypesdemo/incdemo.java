package Datatypesdemo;

public class incdemo
{
    static void main(String[] args) {
        int a=10;
        System.out.println(++(a));
        int x=4, y, z;
        y = --x; // y =3 x= 4->3
        z = x--;// z=3  x=3->2
        System.out.println("x : "+x);
        System.out.println("y : "+y);
        System.out.println("z : "+z);

        x=100;
        System.out.println("x>>2 : "+(x>>2));
    }

}
