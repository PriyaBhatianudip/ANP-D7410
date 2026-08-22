package methods;

public class UserDemo {
    static void main(String[] args) {
//        ArmstrongsDemo ad =new ArmstrongsDemo();
//        ad.menu();

        Calculator cal=new Calculator();
        cal.add(34.32, 45.10);

        cal.add(23, 55);

        int a[]={1,2,4,5,6};
        cal.add(a);
    }
}
//how java compiler decides which method to call when we have
// multiple methods with same name?
// it will recognize the call on the basis paratmeter, which are being passed to
// the method