package lesson_2;

import java.util.Scanner;

/**
 * Created by linhnm on September, 2021
 */

public class AddArray {

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void sumArray(int[] arrA, int[] arrB) {
        for (int i = 0; i < arrA.length; i++) {
            System.out.print((arrA[i] + arrB[i]) + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter n, arrayA, arrayB: ");
        int n = scanner.nextInt();
        int[] arrayA = new int[n];
        int[] arrayB = new int[n];
        for (int i = 0; i < n; i++) {
            arrayA[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arrayB[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arrayA[i] + arrayB[i] + " ");
        }
    }
}
