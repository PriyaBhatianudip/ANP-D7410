package LoopsDemo;

public class DiamondPattern {
    public static void pyramidDiamond5(int rows) {

        for (int r = 1; r <= rows; r++) {
            for (int s = rows; s > r; s--) {
                System.out.print("  ");
            }
            int c;
            for (c = 1; c <= r; c++) {
                System.out.print(c + " ");
            }

            for (int c1 = c - 2; c1 >= 1; c1--) {
                System.out.print(c1 + " ");
            }
            System.out.println();
        }
        for (int r = rows-1; r >=1; r--) {
            for (int s = rows; s > r; s--) {
                System.out.print("  ");
            }
            int c;
            for (c = 1; c <= r; c++) {
                System.out.print(c + " ");
            }

            for (int c1 = c - 2; c1 >= 1; c1--) {
                System.out.print(c1 + " ");
            }
            System.out.println();
        }
    }
    static void main(String[] args) {
    pyramidDiamond5(9);
    }
}
