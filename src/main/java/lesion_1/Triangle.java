package lesion_1;

public class Triangle {
    public static void main(String[] args) {
        System.out.println(isRightTriangle(5, 10, 10, 10, 10, 20));
    }

    static boolean isRightTriangle(double x1, double y1, double x2, double y2, double x3, double y3)
    {
        // begin edit
        double a = distance(x1, y1, x2, y2);
        double b = distance(x2, y2, x3, y3);
        double c = distance(x1, y1, x3, y3);

        return Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)
                || Math.pow(b, 2) + Math.pow(c, 2) == Math.pow(a, 2)
                || Math.pow(a, 2) + Math.pow(c, 2) == Math.pow(b, 2);
        //end edit
    }

    static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}
