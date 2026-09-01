package CodeFiles.src.ExceptionDemo;

public class AgeCheckerException extends  Exception
{
    AgeCheckerException(String msg)
    {
        super(msg);
        System.out.println("Custom Exception Called...");
    }
}
