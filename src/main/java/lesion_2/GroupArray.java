package lesion_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by linhnm on September, 2021
 */

public class GroupArray {

    private static void groupArr(int[] arr) {
        List<Integer> evenList = new ArrayList<>();
        List<Integer> oddList = new ArrayList<>();
        for (int j : arr) {
            if (j % 2 == 0) {
                evenList.add(j);
            } else {
                oddList.add(j);
            }
        }
//        System.out.println();
        for (int odd : oddList) {
            System.out.print(odd + " ");
        }
        for (int even : evenList) {
            System.out.print(even + " ");
        }
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{1, 4, 5, 1, 10, 8, 6, 3, 7};
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter n, array: ");

        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        groupArr(arr);
    }
}
