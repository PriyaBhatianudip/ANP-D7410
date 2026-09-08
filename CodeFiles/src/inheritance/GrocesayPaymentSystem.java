package CodeFiles.src.inheritance;

import java.util.Scanner;

class Payment {
    static double totalAmount = 0;
    double amount = 0;
    static int reciptId = 0;

    public Payment(double amount) {
        this.amount = amount;
        totalAmount += amount;
    }

    double processPayment() {
        //it will receive list of items
        System.out.println("Payment class process payment called");
        return totalAmount;
    }

    void generateRecipt() {
        reciptId++;
        System.out.println("\n---------- Grocery Recipt ------------");
        System.out.println("Recipt ID : " + reciptId);
        System.out.println("Amount Paid : " + amount);
        System.out.println("Total Amount : " + totalAmount);
        System.out.println("Payment Successfull");
    }
}

class Upi extends Payment {
    String upiId;
    double upiAmt = 0;

    public Upi(double amount, String upiId) {
        super(amount);
        this.upiId = upiId;
        this.upiAmt += amount;
    }
    double processPayment() {
        //it will receive list of items
        System.out.println("Upi class process payment called");
        return totalAmount;
    }
}

class CreditCard extends Payment {
    double cardAmt = 0;
    String cardNo;
    int cvv;

    public CreditCard(double amount, String cardNo, int cvv) {
        super(amount);
        this.cardNo = cardNo;
        this.cvv = cvv;
        this.cardAmt += amount;
    }
    double processPayment() {
        //it will receive list of items
        System.out.println("Credit class process payment called");
        return totalAmount;
    }

}

class Wallet extends Payment {
    double cashAmt = 0;

    public Wallet(double amount) {
        super(amount);
        this.cashAmt += amount;
    }
    double processPayment() {
        //it will receive list of items
        System.out.println("Wallet class process payment called");
        return totalAmount;
    }

    public void showvalues()
    {
        System.out.println("Inside show values");
    }
}

//public class GrocesayPaymentSystem {
//    public static void main(String[] args) {
//    int choice;
//        Scanner sc=new Scanner(System.in);
//    do {
//        System.out.println("0. Exit");
//        System.out.println("1. Upi");
//        System.out.println("2. Wallet");
//        System.out.println("3. Credit card");
//        System.out.println("4. Cash");
//        System.out.println("Enter your choice :");
//        choice=sc.nextInt();
//
//        if (choice==0)
//            System.out.println("Goodbye");
//        else if(choice==1)
//        {
//            Upi upi= new Upi(7000, "Danish123");
//            upi.processPayment();
//        }
//        else if(choice==2)
//        {
//            Wallet wallet=new Wallet(7000);
//            wallet.processPayment();
//        }
//        else if(choice==3)
//        {
//            CreditCard card=new CreditCard(4000,"df3343434",123);
//            card.processPayment();
//        }
//        else if(choice==4)
//        {
//            Payment payment=new Payment(4000);
//            payment.processPayment();
//        }
//        else System.out.println("Invalid Choice!!");
//
//    }while(choice!=0);
//
//
//        //        String[][] payments = new String[10][3];
////
////        Payment payemnt1 = new Wallet(5000);
//////        payemnt1.generateRecipt();
////        payemnt1.processPayment();
////
////        Payment payemnt2 = new Upi(7000, "Danish123");
//////        payemnt2.generateRecipt();
////        payemnt2.processPayment();
////
////        Payment payment3 = new CreditCard(3000,"kd32424444",233);
////        payment3.processPayment();
//    }
//}
public class GrocesayPaymentSystem {
    public static void main(String[] args) {
        int choice;

        Payment payment;

        Scanner sc=new Scanner(System.in);
        do
        {
            System.out.println("0. Exit");
            System.out.println("1. Upi");
            System.out.println("2. Wallet");
            System.out.println("3. Credit card");
            System.out.println("4. Cash");
            System.out.println("Enter your choice :");
            choice=sc.nextInt();

            if (choice==0)
                System.out.println("Goodbye");
            else if(choice>=1 && choice<=4) {
                if (choice == 1) {
                    payment = new Upi(7000, "Danish123");

                } else if (choice == 2) {
                    payment = new Wallet(7000);
//                    payment.showvalues();

                } else if (choice == 3) {
                    payment = new CreditCard(4000, "df3343434", 123);

                } else {
                    payment = new Payment(4000);

                }
                payment.processPayment();
                payment.generateRecipt();
            }
            else System.out.println("Invalid Choice!!");
        }while(choice!=0);


        //        String[][] payments = new String[10][3];
//
//        Payment payemnt1 = new Wallet(5000);
////        payemnt1.generateRecipt();
//        payemnt1.processPayment();
//
//        Payment payemnt2 = new Upi(7000, "Danish123");
////        payemnt2.generateRecipt();
//        payemnt2.processPayment();
//
//        Payment payment3 = new CreditCard(3000,"kd32424444",233);
//        payment3.processPayment();
    }
}
//Without dynamic binding
//-> objects are being created at compile time
// -> we need to create an object for each class(child or parent)
// -> same method calls are there with different object

//With dynamic binding
// ->  Objects are being initialized at runtime according to the user's choice
// ->  we only need to create parent class object.
//->  single call to the overridden method will be made.
