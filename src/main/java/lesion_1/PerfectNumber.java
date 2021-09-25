package lesion_1;

public class PerfectNumber {
    public static void main(String[] args) {

    }

    public static boolean isPerfect(int n) {
        int mid = n / 2;
        int sum = 0;
        for (int i = 1; i <= mid; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return n == sum;
    }

    static void printPerfect(int n) {

    }
}
