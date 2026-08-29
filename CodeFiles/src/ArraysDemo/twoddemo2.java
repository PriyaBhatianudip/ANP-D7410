package CodeFiles.src.ArraysDemo;

public class twoddemo2 {
    static void main(String[] args)
    {
            int a[][]={{1,2},{3,4},{5,6}};
        System.out.println("Array Elements : ");

        for(int r=0;r<a.length;r++) {
            for (int c = 0; c < a[r].length; c++) {
                System.out.print(a[r][c] + "\t");
            }
            System.out.println();
        }
    }
}
