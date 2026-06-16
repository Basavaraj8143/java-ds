package arrays;

import java.util.Scanner;

public class setmatrixzero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //System.out.println("enter the row and clo");
        int row = 3;
        //System.out.println("enter the col");
        int col = 3;
        int[][] matrix = new int[row][col];
        System.out.println("enter the elements in the array");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        boolean[] rows = new boolean[row];
        boolean[] cols = new boolean[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }
        for (int i = 0; i < row; i++) {

            if (rows[i]) {
                for (int j = 0; j < col; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 0; j < col; j++) {

            if (cols[j]) {
                for (int i = 0; i < row; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        System.out.println("Result Matrix:");

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();




    }
}
