package lesion_1;

import java.util.Scanner;

public class PalindromeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        String res = "";
        for (int i = Math.min(m, n); i <= Math.max(m, n); i++) {
            if (isPalindrome(i)) res = res + i + " ";
        }

        System.out.println(res);
    }

    private static boolean isPalindrome(int k) {
        return k == reverse(k);
    }

    private static int reverse(int k) {
        int l = k;
        int d = k % 10;
        while (l > 0) {
            l = (l - l % 10) / 10;
            if (l <= 0) return d;
            d = 10 * d + l % 10;
        }
        return d;
    }
}
