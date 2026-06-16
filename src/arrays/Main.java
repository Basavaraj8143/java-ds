import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("enter the row and clo");
        int row = 3;
        System.out.println("enter the col");
        int col = 3;
        int[][] matrix = new int[row][col];
        System.out.println("enter the elements in the array");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int count = 0;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {

                if(matrix[i][j] == 0) {
                    count++;
                }
            }
        }

        System.out.println("Zeros = " + count);
        for(int i = 0; i < row; i++) {

            for(int j = 0; j < col; j++) {

                if(matrix[i][j] == 0) {
                    System.out.println("Zero at: " + i + "," + j);
                    matrix[i][j] = -1;
                }
            }
        }
        System.out.println("elements in the array");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}