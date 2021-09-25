package lesson_1;

public class Exp {
    public static void main(String[] args) {
        System.out.println(dblExp(2, 100));
    }

    public static double dblExp(double x, int n) {

        double sum = 1;
        double t = 1;

        for (int i = 1; i < n; i++) {
            t = t * x / i;
            sum += t;
        }

        return Math.round(sum * 1000.0) / 1000.0;
    }

    private static double fact(int n) {
        double fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }
}
