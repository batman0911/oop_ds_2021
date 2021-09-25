package lesion_1;

public class NumberProps {
    public static void main(String[] args) {
        System.out.println(isPrime(5));
    }

    public static boolean isPrime(int k) {
        if (k == 2) return true;

        for (int i = 3; i <= k / 2; i++) {
            if (k % i == 0) return false;
        }

        return true;
    }
}
