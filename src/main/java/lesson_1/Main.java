package lesson_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter 2 number");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println("sum: " + (a + b));

        System.out.println("sum2: " + sum(1, 2));
    }

    private static int sum(int a, int b) {
        return a + b;
    }
}
