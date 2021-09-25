package lesson_2;

import java.util.Scanner;

/**
 * Created by linhnm on September, 2021
 */

public class DayTang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter n, array: ");

        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        String text = "YES";

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] >= arr[i + 1]) {
                text = "NO";
                break;
            }
        }
        System.out.println(text);
    }
}
