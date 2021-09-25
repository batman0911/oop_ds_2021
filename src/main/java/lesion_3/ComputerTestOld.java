//package lesion_3;
//
//import java.util.Scanner;
//
///**
// * Created by linhnm on September, 2021
// */
//
//public class ComputerTest {
//    private Computer[] computers;
//    private int n;
//
//    // Hàm nhập vào số n và một mảng gồm thông tin của n máy tính
//    public void input(Scanner scan)
//    {
//        System.out.println("enter n and computer info: ");
//        n = scan.nextInt();
//        computers = new Computer[n];
//
//        for (int i = 0; i < n; i++) {
//            String name = scan.nextLine();
//            String manu = scan.nextLine();
//            int year = Integer.parseInt(scan.nextLine());
//            String detail = scan.nextLine();
//            double price = Double.parseDouble(scan.nextLine());
//            computers[i] = new Computer(name, manu, year, detail, price);
//        }
//    }
//
//    // in ra các máy tính, mỗi thông tin của một máy tính trên một dòng
//    public void output()
//    {
//        for (Computer computer : computers) {
//            System.out.println(computer.toString());
//        }
//    }
//
//    // Trả về giá trung bình của các máy tính
//    public double getAvgPrice()
//    {
//        double sum = 0;
//        for (Computer computer : computers) {
//            sum += computer.getPrice();
//        }
//        return sum / computers.length;
//    }
//
//    // In ra các máy tính có giá cao nhất
//    public void getMaxPrice()
//    {
//        Computer computerMax = new Computer();
//        for (int i = 0; i < computers.length; i++) {
//            if (computers[i].getPrice() > computers[i + 1].getPrice()) {
//                computerMax = computers[i];
//            }
//        }
//        System.out.println(computerMax.toString());
//    }
//
//    // In ra các máy tính có nhà sản xuất là Dell
//    public void getDell()
//    {
//        for (Computer computer : computers) {
//            if ("Dell".equals(computer.getManu())) {
//                System.out.println(computer.toString());
//            }
//        }
//    }
//
//    // Sắp xếp các máy tính theo chiều giảm dần của giá, và in ra mảng sau khi sắp xếp
//    public void sort()
//    {
//        Computer temp = new Computer();
//        for (int i = 0; i < computers.length; i++) {
//            for (int j = 0; j < computers.length - i - 1; j++) {
//                if (computers[j].getPrice() < computers[j + 1].getPrice()) {
//                    temp = computers[j];
//                    computers[j] = computers[j + 1];
//                    computers[j + 1] = temp;
//                }
//            }
//        }
//
//        for (Computer computer : computers) {
//            System.out.println(computer.toString());
//        }
//    }
//
//    public static void main(String[] args) {
//
//    }
//}
