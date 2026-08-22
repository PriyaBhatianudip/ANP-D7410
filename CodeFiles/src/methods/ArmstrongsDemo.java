package methods;

import java.util.Scanner;

public class ArmstrongsDemo
{
//    number of digits
    public int countDigits(int num)
    {
        int count=0;
        while(num>0)
        {
            count++;
            num/=10;
        }
        return count;
    }

//    calculate power
    public int calculatePower(int num, int exp)
    {
        int result=1;
        for (int i = 1; i <=exp; i++) {
            result *= num;
        }
        return result;
    }

    public boolean checkArmstrong(int num)// num=153
    {
//        step1 : count digits
        int exp= countDigits(num);// 3
//        start extracting digits one by one
        int sum=0;
        for(int x=num; x>0; x/=10) // x=153  1>0  15/10=1
        {
//            extract last digit
            int m = x%10; // 1
//            find the power of this digit(m^exp)
            int result = calculatePower(m,exp);// 1,3= 1
//            add this result into sum
            sum+=result;            // sum=0+27+125+1= 153
        }
//        check if the number is equals to sum or not
        if(sum==num) return true;
        else return false;
    }

//    print all armstrong numbers in the given range
    public void printArmstrong(int start, int end)
    {
        for (int i = start; i <= end; i++) {
            if (checkArmstrong(i)) {
                System.out.print(i + " ");
            }
        }
    }
//program should not exit until user choose 5th option.
    public void menu()
    {
        Scanner sc=new Scanner(System.in);
        int choice;
        do
        {
            System.out.println("1. Calculate Number of digits");
            System.out.println("2. Calculate Power");
            System.out.println("3. Check Armstrong");
            System.out.println("4. Print Armstrong");
            System.out.println("5. Exit");
            System.out.println("Enter your choice : ");
            choice=sc.nextInt();

            switch (choice)
            {
                case 1:
                {
                    System.out.println("Enter a number : ");
                    int digits = countDigits(sc.nextInt());// input-> call method
                    System.out.println("Number of Digits : "+digits);
                    break;// it will exit the switch case
                }
                case 2:
                {
                    System.out.println("Enter the number and its exponent : ");
                    int result = calculatePower(sc.nextInt(), sc.nextInt());
                    System.out.println("Number of Digits : "+result);
                    break;
                }
                case 3:
                {
                    System.out.println("Enter a number : ");
                    if(checkArmstrong(sc.nextInt())) System.out.println("Armstrong Number!!");
                    else System.out.println("Not an Armstrong Number!!");
                    break;// it will exit the switch case
                }
                case 4:
                {
                    System.out.println("Enter start and End range : ");
                    printArmstrong(sc.nextInt(), sc.nextInt());
                    break;
                }
                case 5: {
                    System.out.println("GoodBye!!");
                    break;
                }
                default:
                {
                    System.out.println("You have entered wrong value!! Try Again!!");
                }
            }
        }while (choice!=5);
        System.out.println("Have a Nice Day!!");
    }
}
