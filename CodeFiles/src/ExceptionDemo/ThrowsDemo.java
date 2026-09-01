package CodeFiles.src.ExceptionDemo;


import java.io.IOException;
import java.util.Scanner;

public class ThrowsDemo {
    static String password = "Danish@123";

    public static void passwordCheck() throws IOException
    {
        String newPassword;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter password : ");
        newPassword = sc.nextLine();
        if (newPassword.equals(password)) {
            System.out.println("Login Successfull");
        }
        else
        {
            throw new IOException("Invalid Password Try Again");
        }
    }

    public static void main(String[] args) //throws IOException
    {
        int attempts=1;
        while(attempts<=3) {
            try {
                passwordCheck();// if exception comes break will be ignored. it jumps straight to catch
                break;
            } catch (IOException ie) {
                System.out.println("Error : " + ie.getMessage());
                attempts++;
            }
        }
    }

}