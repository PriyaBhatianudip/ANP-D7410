package OOPs;

import java.util.Scanner;

public class Bankdemo {
    public UserAccount createUser()
    {
        Scanner sc=new Scanner(System.in);
        UserAccount user =new UserAccount();
        System.out.println("Enter Account number : ");
        user.setAccountno(sc.nextInt());
        sc.nextLine();
        System.out.println("Enter Name : ");
        user.setAcname(sc.nextLine());

        System.out.println("Enter Account type : ");
        user.setType(sc.nextLine());

        System.out.println("Enter Initial Balance : ");
        user.setBalance(sc.nextInt());

        System.out.println("Enter Pin : ");
        user.setUserpin(sc.nextInt());
        return user;
    }
    static void main(String[] args) {
        Bankdemo bd=new Bankdemo();

        UserAccount user1=bd.createUser();
        UserAccount user2 =bd.createUser();

        System.out.println(user1);
        System.out.println(user2);
    }
}
