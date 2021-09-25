package lesson_2;

/**
 * Created by linhnm on September, 2021
 */

public class SortArray {

    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        int tmp;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,0,2,9};
        bubbleSort(arr);
    }
}
