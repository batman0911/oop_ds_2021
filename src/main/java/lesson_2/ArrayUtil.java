package lesson_2;

public class ArrayUtil {
    public static void main(String[] args) {
        int[] arr = new int[] {3, 4, 1, 0};
        System.out.println(max(arr));
        System.out.println(sumArr(arr));
//        System.out.println(maxPrime(arr));
    }

    private static int sumArr(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    private static int max(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            max = Math.max(arr[i + 1], max);
        }

        return max;
    }

    private static boolean checkSign(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] * arr[i + 1] > 0) return false;
        }
        return true;
    }

    private static void printPrime(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (checkPrime(arr[i]))
                System.out.println(arr[i]);
        }
    }

//    private static int maxPrime(int[] arr) {
//        for (int i = arr.length - 1; i > 0; i--) {
//            if (checkPrime(arr[i])) return arr[i];
//        }
//        return -1;
//    }

    private static boolean checkPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
