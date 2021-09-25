package lesson_3.computer;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by linhnm on September, 2021
 */

public class ComputerTest {

    // hàm ghi ra file dưới dạng Object, trong đó filename là tên file truyền vào, coms là danh sách các Computer muốn ghi ra file
    public static void outputObject(String fileName, ArrayList<Computer> coms) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream buff = new ObjectOutputStream(fileOutputStream);
            for (Computer computer : coms) {
                buff.writeObject(computer);
            }
            buff.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void inputObject(String fileName, ArrayList<Computer> coms) {
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream buff = new ObjectInputStream(fileInputStream);
            Computer computer;
//            while ((computer = (Computer) buff.readObject()) != null) {
//                coms.add(computer);
//            }
            while (true) {
                computer = (Computer) buff.readObject();
                coms.add(computer);
            }

        }
        catch (EOFException e) {
            return;
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Hàm in ra màn hình thông tin của các máy tính trong danh sách computers
    public static void output(ArrayList<Computer> computers)
    {
        for(int i =0; i < computers.size(); i ++)
            System.out.println(computers.get(i).toString());
    }

    // Hàm trả về giá trung bình của các máy tính trong danh sách coms
    public static double getAvgPrice(ArrayList<Computer> coms)
    {
        double sum = 0;
        for (Computer computer : coms) {
            sum += computer.getPrice();
        }
        return sum / coms.size();
    }

    // Hàm trả về các máy tính có giá lớn nhất
    public static ArrayList<Computer> getMaxPrice(ArrayList<Computer> coms)
    {
        double maxPrice = coms.get(0).getPrice();
        ArrayList<Computer> maxComputerList = new ArrayList<>();
        for (Computer computer : coms) {
            if (computer.getPrice() > maxPrice) {
                maxPrice = computer.getPrice();
                maxComputerList.clear();
                maxComputerList.add(computer);
            }
        }
        return maxComputerList;
    }

    // Hàm trả về danh sách các máy tính có hãng sản xuất là Dell
    public static ArrayList<Computer> getDell(ArrayList<Computer> coms)
    {
        ArrayList<Computer> computers = new ArrayList<>();
        for (Computer computer : coms) {
            if (computer.getManu().equals("Dell")) {
                computers.add(computer);
            }
        }
        return computers;
    }

    // Hàm sắp xếp tên theo thứ tự từ điển và in ra danh sách các máy tính sau khi sắp xếp
    public static void sort(ArrayList<Computer> coms)
    {
        List<Computer> sortedComs = coms.stream()
                .sorted(Comparator.comparing(Computer::getName))
                .collect(Collectors.toList());
        coms = (ArrayList<Computer>) sortedComs;
    }

    public static void main(String[] args) {
        ComputerTest test = new ComputerTest();
        ArrayList<Computer> newC = new ArrayList<>();
        test.inputObject("computer.dat", newC);
        ArrayList<Computer> dell = test.getDell(newC);
        test.outputObject("dell.dat", dell);
    }
}
