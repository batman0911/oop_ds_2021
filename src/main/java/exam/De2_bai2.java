package exam;

import java.util.Scanner;

/**
 * Created by linhnm on September, 2021
 */

public class De2_bai2 {
    /*  thực hiện nhập số nguyên m, n và trả lại mảng hai chiều m x n số nguyên nhập từ bàn phím */
    public static int[][] readMatrix(Scanner reader){
        // bổ sung mã lệnh - Có thể thay giá trị trả về đúng với kiểu được yêu cầu
        int m = reader.nextInt();
        int n = reader.nextInt();

        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = reader.nextInt();
            }
        }
        return matrix;
    }

    /* thực hiện việc in mảng hai chiều Mtr ra màn hình dạng ma trận */
    public static void printMatrix(int[][] Mtr) {
        // bổ sung mã lệnh
        for (int i = 0; i < Mtr.length; i++) {
            for (int j = 0; j < Mtr[0].length; j++) {
                System.out.print(Mtr[i][j] + " ");
            }
            System.out.println();
        }
    }

    /* thực hiện kiểm tra trong ma trận Mtr có tồn tại hai dòng trực giao với nhau */
    public static boolean isRowsOrthgonal(int[][] Mtr){
        // bổ sung mã lệnh - Có thể thay giá trị trả về đúng với kiểu được yêu cầu
        int m = Mtr.length;

        for (int i = 0; i < m - 1; i++) {
            for (int j = i; j < m; j++) {
                if (product(Mtr[i], Mtr[j]) == 0) {
                    return true;
                }
            }
        }

        return false;
    }

    private static int product(int[] v1, int[] v2) {
        int sum = 0;
        for (int i = 0; i < v1.length; i++) {
            sum += v1[i] * v2[i];
        }
        return sum;
    }

    /*  thực hiện tìm và trả về giá trị lớn nhất trong các phần tử cột thứ k của Mtr (chỉ số chiều thứ hai). */
    public static int maxColsMember(int[][] Mtr, int k) {
        // bổ sung mã lệnh - Có thể thay giá trị trả về đúng với kiểu được yêu cầu
        int max = 0;
        for (int i = 0; i < Mtr.length; i++) {
            if (Mtr[i][k] > max) max = Mtr[i][k];
        }
        return max;
    }

    /* thực hiện việc tính và in giá trị lớn nhất trong phần tử các cột của Mtr ra màn hình */
    public static void printColsMax(int[][] Mtr) {
        // bổ sung mã lệnh
        for (int j = 0; j < Mtr[0].length; j++) {
            System.out.print(maxColsMember(Mtr, j) + " ");
        }
        System.out.println();
    }
}
