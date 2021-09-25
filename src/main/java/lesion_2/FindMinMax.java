package lesion_2;

import java.util.Scanner;

/**
 * Created by linhnm on September, 2021
 */

public class FindMinMax {

    private static int findMin(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            min = Math.min(min, arr[i + 1]);
        }
        return min;
    }

    private static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            max = Math.max(max, arr[i + 1]);
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter n, array: ");

        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(findMin(arr) + " " + findMax(arr));
    }
}
