package lesion_2;

import java.util.Scanner;

/**
 * Created by linhnm on September, 2021
 */

public class PrimesInArray {

    private static boolean isPrime(int k){
        if (k < 2) return false;

        for (int i = 2; i <= k / 2; i++) {
            if (k % i == 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter n, arr: ");

        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (isPrime(arr[i])) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
