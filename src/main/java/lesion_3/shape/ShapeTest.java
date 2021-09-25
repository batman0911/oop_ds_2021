package lesion_3.shape;

import java.util.ArrayList;
import java.util.Scanner;

public class ShapeTest {
    public static ArrayList<Shape> readData() {
        ArrayList<Shape> shapes = new ArrayList<Shape>();
        // Đọc dữ liệu vào danh sách shapes
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] contentArr = scanner.nextLine().split(" ");
            if (contentArr[0].equals("c")) {
                shapes.add(new Circle(Double.parseDouble(contentArr[1])));
            } else if (contentArr[0].equals("s")) {
                shapes.add(new Square(Double.parseDouble(contentArr[1])));
            } else if (contentArr[0].equals("r")) {
                shapes.add(new Rectangle(
                        Double.parseDouble(contentArr[1]),
                        Double.parseDouble(contentArr[2])
                ));
            }
        }
        return shapes;
    }


    public static Circle getMaxCircle(ArrayList<Shape> shapes) {
        double maxArea = 0;
        Circle circle = null;
        for (Shape shape : shapes) {
            if (shape instanceof Circle && shape.getArea() > maxArea) {
                maxArea = shape.getArea();
                circle = (Circle) shape;
            }
        }

        return circle;
    }


    public static Square getMaxSquare(ArrayList<Shape> shapes) {
        double maxArea = 0;
        Square square = null;
        for (Shape shape : shapes) {
            if (shape instanceof Square && shape.getArea() > maxArea) {
                maxArea = shape.getArea();
                square = (Square) shape;
            }
        }

        return square;
    }

    public static Rectangle getMaxRectangle(ArrayList<Shape> shapes) {
        double maxArea = 0;
        Rectangle rectangle = null;
        for (Shape shape : shapes) {
            if (shape instanceof Rectangle && shape.getArea() > maxArea) {
                maxArea = shape.getArea();
                rectangle = (Rectangle) shape;
            }
        }

        return rectangle;
    }

    public static void main(String[] args) {
        ArrayList<Shape> shapes = readData();
        sort(shapes);
        Circle c = getMaxCircle(shapes);
        Square s = getMaxSquare(shapes);
        Rectangle r = getMaxRectangle(shapes);
        if (c != null) {
            System.out.printf("Circle %.2f\n", c.getArea());
        } else {
            System.out.println("Circle =  null");
        }
        if (s != null) {
            System.out.printf("Square %.2f\n", s.getArea());
        } else {
            System.out.println("Square =  null");
        }

        if (r != null) {
            System.out.printf("Rectangle %.2f\n", r.getArea());
        } else {
            System.out.println("Rectangle =  null");
        }

    }

    public static void sort(ArrayList<Shape> shapes) {
        int n = shapes.size();

        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++) {
                if ((shapes.get(i)).compareTo(shapes.get(j)) > 0) {
                    Shape temp = shapes.get(i);
                    shapes.set(i, shapes.get(j));
                    shapes.set(j, temp);
                }
            }
    }
}
