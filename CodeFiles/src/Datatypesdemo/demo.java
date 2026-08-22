package Datatypesdemo;

public class demo {
    public static void main(String[] args) {
        int a=235;
        int b = 2332;

        System.out.println("sum : "+a+b);
        System.out.println("sum : "+(a+b));

        System.out.println("Divide : "+(a/b));
        System.out.println("Remaining value : "+(a%b));

        System.out.println("a > b : "+(a>b));
        System.out.println("a < b : "+(a<b));
        System.out.println("a == b : "+(a==b));
        System.out.println("a  != b : "+(a!=b));

        int c=200;
        System.out.println("A is greatest : "+((a>b) && (a>c)));
        System.out.println("B is greatest : "+((b>a) && (b>c)));
        System.out.println("C is greatest : "+((c>a) && (c>b)));

    }
}
