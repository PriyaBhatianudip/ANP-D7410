package CodeFiles.src.ExceptionDemo;

import java.io.IOException;
import java.util.Scanner;

public class ThrowException {
    static String password = "Danish@123";

    public static void passwordCheck()
    {
        String newPassword;
        Scanner sc = new Scanner(System.in);

        for(int attempts=1;attempts<=3;)
        {
            System.out.print("Enter password : ");
            newPassword = sc.nextLine();
            try {
                if (newPassword.equals(password)) {
                    System.out.println("Login Successfull");
                    break;
                }
                else
                {
                    attempts++;
                    throw new IOException("Invalid Password Try Again");
                }
            } catch (IOException e)
            {
                System.out.println(e.getMessage());
            }
            finally
            {
                System.out.println("finally is in work...");
            }
        }
    }

    public static void main(String[] args)
    {
        passwordCheck();
    }

}