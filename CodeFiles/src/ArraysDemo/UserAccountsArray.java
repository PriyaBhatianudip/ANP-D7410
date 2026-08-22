package ArraysDemo;

import OOPs.UserAccount;
import java.util.Scanner;

public class UserAccountsArray
{
    Scanner sc;
    UserAccount users[];
    //
    int top;


    public UserAccountsArray(int size)
    {
        sc=new Scanner(System.in);
        users=new UserAccount[size];
        top=-1;
    }

//    create a user account
public UserAccount createUser()
{
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
public void setUserAccount()
{
    users[++top]=createUser();
}
public UserAccount searchUser(int accountno)
{
    for (int index = 0; index <= top; index++)
    {
        if (users[index].getAccountno() == accountno)
        {
            return users[index];
        }
    }
    System.out.println("No User Found");
    return null;
}

public void printAllUsers()
{
    if(top==-1)
    {
        System.out.println("No User Accounts Found!!");
    }
    else
    {
        System.out.println("======================================");
        System.out.println("All user Details");
        for(int i=0;i<=top;i++)
            System.out.println(users[i]);
        System.out.println("======================================");
    }

}
public void updateUser(int accountno)
{

}
public void menu()
{
    int choice;
//    1. add user
//    2. view user-> input account no->
//    3. view all users
//    4. update user details
//    5. Exit
    do {
        System.out.println("1. add user");
        System.out.println("2. view user");
        System.out.println("3. view all user");
        System.out.println("4. update user detail");
        System.out.println("5. exit");
        System.out.println();
        System.out.println("you choose a task 1 to 5: " );
        choice = sc.nextInt();

        switch (choice) {
            case 1:
               setUserAccount();
                break;

            case 2:
                System.out.println("Enter Account Number : ");
                searchUser(sc.nextInt());
                break;

            case 3:

                printAllUsers();
                break;

            case 4:
                System.out.println("Enter Account Number : ");
                updateUser(sc.nextInt());
                break;

            case 5:
                System.out.println("end of task");
                break;
            default:
                System.out.println("Wrong Choice!! Try Again!!");
        }
    }while(choice!=5);
}
    static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of user accounts : ");
        UserAccountsArray ob=new UserAccountsArray(sc.nextInt());
    }
}
