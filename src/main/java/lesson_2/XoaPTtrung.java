package lesson_2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linhnm on September, 2021
 */

public class XoaPTtrung {

    private static int[] xoaPhantu(int[] arr, int k) {
        int[] res = new int[arr.length - 1];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }

        for (int i = k; i < arr.length - 1; i++) {
            res[i] = arr[i + 1];
        }

        return res;
    }

    public static void main(String[] args) {
//        System.out.println(xoaPhantu(new int[]{1, 2, 3, 4, 5}, 2));
        int[] arr = new int[]{1, 2, 3, 4, 5, 2, 3, 1};
        int[] res = xoaPhantu(arr, 2);
        for (int i = 0; i < 4; i++) {
            System.out.println(res[i]);
        }

        List<Integer> result = new ArrayList<>();
        for (int j : arr) {
            if (result.contains(j)) {
                continue;
            }
            result.add(j);
        }

        for (int j : result) {
            System.out.print(j + " ");
        }
    }
}
