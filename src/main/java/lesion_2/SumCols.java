package lesion_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by linhnm on September, 2021
 */

public class SumCols {

    private static void sumCols(int[][] matrix) {
        List<Integer> sumColList = new ArrayList<>();
        for (int j = 0; j < matrix[0].length; j++) {
            int sum = 0;
            for (int i = 0; i < matrix.length; i++) {
                sum += matrix[i][j];
            }
            sumColList.add(sum);
        }

        for (int sum : sumColList) {
            System.out.print(sum + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter m, n, matrix A: ");
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        sumCols(matrix);
    }
}
