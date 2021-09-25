package lesson_2;

import java.util.Scanner;

/**
 * Created by linhnm on September, 2021
 */

public class Matrix2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int c = Integer.parseInt(scanner.nextLine());
        switch (c) {

        }
    }

    private boolean checkFirstLast(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] != matrix[i][n - 1]) return false;
        }
        return true;
    }

    private boolean checkDuplicate(int[][] matrix) {
        int n = matrix.length;
        boolean isDuplicate = false;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (matrix[k][i] != matrix[k][j]) {
                        isDuplicate = false;
                        break;
                    }
                    isDuplicate = true;
                }
            }
        }
        return isDuplicate;
    }

}
