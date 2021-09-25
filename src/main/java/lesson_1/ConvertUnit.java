package lesson_1;

public class ConvertUnit {
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Math.round(x * 39.3700787 * 100.00) / 100.00;
        System.out.println(y);
    }
}
