package CodeFiles.src.OOPs;

public class staticdemo
{
    int visitornumber=0; // object level variable
    static int totalcount=0;  // class level variable
// 1
    static
    {
        System.out.println("static block executed!!");
        System.out.println("Program is loading....");
    }

    public static void incrementCounter(staticdemo user)
    {
//        new staticdemo().visitornumber++;
        user.visitornumber++;
        totalcount++;
    }

    public void displayValues()
    {
        System.out.println("Visitor Number : "+visitornumber);// user1(1), user2(2)
        System.out.println("Total Count : "+totalcount);// 2
    }
    static void main(String[] args)
    {
        staticdemo user1 =new staticdemo();
        staticdemo user2 =new staticdemo();

        incrementCounter(user1);
        user1.displayValues();
        incrementCounter(user2);
        user2.displayValues();
    }
}
// user1  visitornumber=0 1
// user2  visitornumber=0 1
// class -> totalcount = 0 1 2