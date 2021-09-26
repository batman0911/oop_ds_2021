package exam;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by linhnm on September, 2021
 */

public class AthleteManager {
    /* Khởi tạo một ArrayList có kiểu Athlete
     * Khai báo một biến Scanner đọc dữ liệu từ tệp có tên filename
     * Đọc n
     * Đọc từng thuộc tính của một Athlete
     * Khởi tạo một đối tượng Athlete với các thuộc tính vừa đọc được từ file
     * Add vào ArrayList
     * */
    public static ArrayList<Athlete> readFile(String filename)
    {
        ArrayList<Athlete> athletes = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(filename));
            int n = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < n; i++) {
                String name = scanner.nextLine();
                int year = Integer.parseInt(scanner.nextLine());
                String sport = scanner.nextLine();
                double weight = Double.parseDouble(scanner.nextLine());
                double height = Double.parseDouble(scanner.nextLine());
                athletes.add(new Athlete(name, year, sport, weight, height));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return athletes;
    }

    /*
     * In dữ liệu của từng vận động viên sử dụng toString()
     * Phương thức này không cần sửa gì
     */
    public static void print(ArrayList<Athlete> aths)
    {
        for(Athlete a: aths)
        {
            System.out.println(a.toString());
        }
    }

    /*
     * Tính chỉ số BMI của từng vận động viên
     * BMI được tính theo công thức BMI = cân nặng/(chiều cao *chiều cao)
     * Trong đó cân nặng được tính bằng kg, chiều cao được tính bằng m
     * In mỗi chỉ số BMI với 3 chữ số sau dấu phẩy, mỗi chỉ số cách nhau một dấu tab (\t)
     */
    public static void printBMIs(ArrayList<Athlete> aths)
    {
        for (Athlete athlete : aths) {
            double bmi = athlete.getWeight() / (athlete.getHeight() * athlete.getHeight() / 10000);
            System.out.printf("%.3f\t", bmi);
        }
    }

    /*
     * Tìm và trả về các vận động viên có môn thi đấu là sport (với sport sẽ được truyền vào cụ thể khi gọi hàm)
     */
    public static ArrayList<Athlete> findSport(ArrayList<Athlete> aths, String sport)
    {
        return aths
                .stream()
                .filter(athlete -> athlete.getSport().equals(sport))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /*
     * Tìm và trả về các vận động viên có chiều cao cao nhất
     */
    public static ArrayList<Athlete> findAthlete(ArrayList<Athlete> aths)
    {
        double maxHeight = aths.get(0).getHeight();
        ArrayList<Athlete> maxHeightList = new ArrayList<>();
        for (Athlete ath : aths) {
            if (ath.getHeight() > maxHeight) {
                maxHeight = ath.getHeight();
                maxHeightList.clear();
                maxHeightList.add(ath);
            }
        }
        return maxHeightList;
    }
    /*
     * Sắp xếp danh sách theo thứ tự từ điển của họ và tên (a-z)
     * In ra danh sách sau khi sắp xếp
     */
    public static void sort(ArrayList<Athlete> aths)
    {
        // Sắp xếp
        ArrayList<Athlete> sortedList = aths.stream()
                .sorted(Comparator.comparing(Athlete::getName))
                        .collect(Collectors.toCollection(ArrayList::new));

        // In danh sách sau khi sắp xếp
        print(sortedList);
    }

    // Hàm main không cần phải sửa gì

    public static void main(String[] args) {
        ArrayList<Athlete> aths = readFile("athletes.txt");
        print(aths);
        printBMIs(aths);
        System.out.println();
        print(findSport(aths, "Bong Chuyen"));
        print(findAthlete(aths));
        System.out.println("SORT: ");
        sort(aths);
    }
}
