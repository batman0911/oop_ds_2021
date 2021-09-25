package lesson_4;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by linhnm on September, 2021
 */

public class CarManagement {
    // Hàm dựng
    public CarManagement(){
        super();
    }

    // Phương thức readData() cho phép đọc dữ liệu từ tệp văn bản
	/*
	    Thứ tự nhập như sau:
	    - Nhập số lượng xe
	    - Trong vòng lặp với mỗi loại xe:
	       - Nhập 1 số nguyên c, c = 0 là ServiceCar, c = 1 là SportCar
	       - Nhập thông tin của các xe: id, name, manufacturer, hours, price, fee (Đối với ServiceCar, tax với SportCar)
	*/

    public ArrayList<Car> readData(String fileName) {
        ArrayList<Car> cars = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new FileInputStream(fileName));
            int totalCar = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < totalCar; i++) {
                int c = Integer.parseInt(scanner.nextLine());
                String id = scanner.nextLine();
                String name = scanner.nextLine();
                String manu = scanner.nextLine();
                double hours = Double.parseDouble(scanner.nextLine());
                double price = Double.parseDouble(scanner.nextLine());
                double feeOrTax = Double.parseDouble(scanner.nextLine());
                if (c == 0) {
                    cars.add(new ServiceCar(id, name, manu, hours, price, feeOrTax));
                } else if (c == 1) {
                    cars.add(new SportCar(id, name, manu, hours, price, feeOrTax));
                }
            }

            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cars;
    }

    // Phương thức in danh sách thông tin liên quan các loại xe trong mảng
    public void printCars(ArrayList<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i).toString());
        }
    }

    // Phương thức xuất ra danh sách những xe có tên nhà sản xuất là "manuName"
    public ArrayList<Car> findCars(ArrayList<Car> cars, String manuName){
        return cars.stream()
                .filter(car -> car.getManufacturer().equals(manuName))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    // Phương thức xuất ra danh sách những xe giá thành tiền (amount) cao nhất thuộc loại typeOfCars

    public ArrayList<Car> getMaxAmount(ArrayList<Car> cars, String typeOfCars){
        ArrayList<Car> carByType = cars
                .stream()
                .filter(car -> {
                    if (typeOfCars.equals("ServiceCar")) {
                        return car instanceof ServiceCar;
                    } else if (typeOfCars.equals("SportCar")) {
                        return car instanceof SportCar;
                    }
                    return true;
                })
                .collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Car> maxAmountCarList = new ArrayList<>();
        double max = carByType.get(0).getAmount();
        maxAmountCarList.add(carByType.get(0));
        for (Car car : carByType) {
            if (car.getAmount() > max) {
                max = car.getAmount();
                maxAmountCarList.clear();
                maxAmountCarList.add(car);
            }
        }

        return maxAmountCarList;

    }

    // Phướng thức sắp xếp giá thành tiền các loại xe theo thứ tự giảm dần
    public void sortByAmount(ArrayList<Car> cars){
        //Begin editable part
        cars.sort(Collections.reverseOrder((car1, car2) -> (int) (car1.getAmount() - car2.getAmount())));
    }

    // Hàm main
    public static void main(String[] args) {
        CarManagement carManag = new CarManagement();
        ArrayList<Car> cars = carManag.readData("data.txt");
        //	carManag.printCars(cars);

        for (int i = 0; i < cars.size(); i++) {
            System.out.print(cars.get(i).getAmount() + " ");
//            System.out.println(cars.get(i).toString());
        }
        System.out.println();
        ArrayList<Car> carsList = carManag.findCars(cars,"honda");
        carManag.printCars(carsList);

        ArrayList<Car> carsList1 = carManag.getMaxAmount(cars, "SportCar");
        carManag.printCars(carsList1);

        carManag.sortByAmount(cars);
        carManag.printCars(cars);

    }
}
