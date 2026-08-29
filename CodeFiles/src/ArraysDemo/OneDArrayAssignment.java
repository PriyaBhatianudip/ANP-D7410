package CodeFiles.src.ArraysDemo;

import java.util.Scanner;

public class OneDArrayAssignment {
    int a[];
    Scanner sc;
    int index;

//constructor
    OneDArrayAssignment(int size)
    {
        a = new int[size];
        sc = new Scanner(System.in);
        index = -1;
    }

//    checks whether the array is empty
    public boolean isEmpty()
    {
        if(index==-1) return true;

        return false;
    }

    public boolean isFull()
    {
        if(index==a.length-1) return true;

        return false;
    }
//array[index=-1]     deletearray(array[index--]=0)  array[-1]=0, ArrayIndexOutOfBoundsException
//    create a function to insert a new value in array at the availableIndex
    public void insertEnd()
    {
        if(isFull())
            System.out.println("Array is Full!!Can't insert new value!!");
        else {
            System.out.println("Enter a new value : ");
            a[++index]=sc.nextInt();
            System.out.println("Value inserted successfully!!");
        }
    }
    public void display()
    {
        System.out.println("Array Elements are :-");
        for(int value:a) System.out.print(value+"\t");
        System.out.println("\n======================================");
    }
    public void rotateClockwise() {
        System.out.println("Before Rotation Array Elements");
        display();
        int num = a[index];

        for (int i = index; i >0; i--)
        {
            a[i] = a[i - 1];
        }
        a[0] = num;
        System.out.println("After Rotation Array Elements");
        display();
    }
    public void rotateAntiClockwise()
    {
        if (isEmpty()){
            System.out.println("array is empty: ");
            return;
        }
        System.out.println("Before Rotation Array Elements");
        display();

        int temp = a[0];
        for (int i = 0; i <= index-1 ; i++) {
            a[i]= a[i+1];
        }
        a[index] = temp;
        System.out.println("After Rotation Array Elements");
        display();
    }
    public void insertAtBeginning()
    {
        if (isFull()) {
        System.out.println("Array is full");
        return;
    }
//        0 1   2   3   4   5   6   7   8
//        1 2   3   4   5   6   7
//        index = 6
        for (int i = index+1; i > 0; i--) {// i= 7
            a[i] = a[i - 1];  // a[7]=a[6]
        }
        System.out.print("Enter value: ");
        a[0] = sc.nextInt();
        index++;
        System.out.println("Insertion Completed successfully!!");
        System.out.println("Array after Insertion :");
        display();
    }
    public void deleteValue()
    {
        if(isEmpty()) System.out.println("Array is Empty!!");
        else
        {
            a[index--]=0;
            System.out.println("Value Deleted Successfully!!");
        }
    }
    public int search()
    {
        if (isEmpty()) {
            System.out.println("Empty array");
            return -2;
        }
        System.out.println("Enter search value : ");
        int num=sc.nextInt();
        for (int i = 0; i <=index; i++) {
            if (num == a[i]) {
                return i;
            }
        }
        return -1;
    }
    public void replaceValue() {
        int i = search();
        if(i==-1) System.out.println("Value not found!!");
        else if(i!=-2)
        {
            System.out.println("Enter New Value : ");
            a[i]=sc.nextInt();
            System.out.println("Value Updated Successfully!!");
            display();
        }
    }
    public void insertByValue() {
        int idx = search();
        if (idx == -1) System.out.println("Value Not Found!!");
        else if (idx != -2) {
            System.out.print("Enter new value: ");
            int newValue = sc.nextInt();

            for (int i = index + 1; i > idx; i--) {
                a[i] = a[i - 1];
            }

            a[idx] = newValue;
            System.out.println("Value inserted successfully.");
        }
    }
    public void menu()
    {
        char ch;

        do {
            System.out.println("1. Insert at End");
            System.out.println("2. Display");
            System.out.println("3. Rotate Array Clockwise");
            System.out.println("4. Rotate Array Anti Clockwise");
            System.out.println("5. Insert Value at 0 Index");
            System.out.println("6. Delete Last Value");
            System.out.println("7. Search");
            System.out.println("8. Replace ");
            System.out.println("Enter your choice : ");
//            int choice=sc.nextInt()
            switch (sc.nextInt())
            {
                case 1:
                {
                    insertEnd();
                    break;
                }
                case 2: {
                    display();
                    break;
                }
                case 3:
                {
                    System.out.println("Enter Number of rotations: ");
                    int n=sc.nextInt();

                    while(n>0)
                    {
                        rotateClockwise();
                        n--;
                    }
                    break;
                }
                case 4:
                {
                    System.out.println("Enter Number of rotations: ");
                    int n=sc.nextInt();

                    while(n>0)
                    {
                       rotateAntiClockwise();
                        n--;
                    }
                    break;
                }
                case 5:
                {
                    insertAtBeginning();

                    break;
                }
                case 6:
                {
                    deleteValue();
                    break;
                }
                case 7:
                {
                    int i=search();
                    if(i==-1) System.out.println("Value Not Found!!");
                    else if(i!=-2)
                    {
                        System.out.println("Value found at "+i+" index!!");
                    }
                    break;
                }
                case 8:
                {
                    replaceValue();
                    break;

                }
                default:
                    System.out.println("Wrong choice!!");
            }

            System.out.println("Do You want to continue(y/n)");
            ch=sc.next().charAt(0);

        }while(ch=='y'||ch=='Y');
    }
    static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the size of array : ");
        OneDArrayAssignment oned=new OneDArrayAssignment(sc.nextInt());
       oned.menu();

    }
}
