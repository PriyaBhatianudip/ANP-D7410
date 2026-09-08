package CodeFiles.src.inheritance.PaymentSystem;

import java.util.Scanner;

class Payment
{
    static double totalAmount = 0;  //0+5000+7000=12000
    double amount = 0;  // 7000
    static int reciptId = 0;//  =0+1

    public Payment(double amount) {// 7000
        this.amount = amount;
        totalAmount += amount;
    }

//    double processPayment() {
//        //it will receive list of items
//        reciptId++;
//        return amount;
//    }

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
    String upiId;//"Danish123"
    double upiAmt = 0;  //7000

    public Upi(double amount, String upiId) {// amount=7000, upiId="Danish123"
        super(amount);
        this.upiId = upiId;
        this.upiAmt += amount;
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


}

class Wallet extends Payment {
    double cashAmt = 0;  // = 0+5000

    public Wallet(double amount) {
        super(amount);
        this.cashAmt += amount;
    }
}
class ProductPurchaseList
{
    Scanner sc;
    ProductDetails pd;
    String[][] list;
    ProductPurchaseList()
    {
        sc=new Scanner(System.in);
        pd=new ProductDetails();
    }
    public String[][] prepareList() {
        System.out.println("Enter number of Items : ");
        int n = sc.nextInt();
        list = new String[n][6];

//        "Product_ID", "Product_Name","Category", "Sales_Price","Total_Amount"
        for (int r = 0; r < list.length; r++) {
            int c = 0;
            sc.nextLine();
            System.out.println("Enter Product id : ");
            list[r][c] = sc.nextLine();   // id
            int index = pd.getProductIndex(list[r][c]);
            list[r][++c] = pd.products[index][1];// name
            list[r][++c] = pd.products[index][2];// category
            list[r][++c] = pd.products[index][3];// salesprice
            System.out.println("Enter quantity : ");
            int qty = sc.nextInt();
            double saleprice = Integer.parseInt(list[r][3]);
            list[r][++c] = String.valueOf(qty);// quantity

            list[r][++c] = String.valueOf(saleprice * qty); // totalprice
        }
        for (int r = 0; r < list.length; r++) {
            for (int c = 0; c < list[r].length; c++) {
                System.out.print(list[r][c] + "\t");
            }
            System.out.println();
        }
        return list;
    }
}
public class GrocesayPaymentSystem
{
    public void menu()
    {
        System.out.println("Enter Amount : ");

//        Payment payment=new Payment();

    }
    public static void main(String[] args) {

//
//        Payment payemnt1 = new Wallet(5000);
//        payemnt1.generateRecipt();
//
//        Payment payemnt2 = new Upi(7000, "Danish123");
//        payemnt2.generateRecipt();

        ProductPurchaseList pp=new ProductPurchaseList();
        pp.prepareList();
    }
}
