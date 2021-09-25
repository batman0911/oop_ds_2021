package lesson_3.motobike;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by linhnm on September, 2021
 */

public class MotorbikeTest {

    private static Motorbike createMotorbike(Scanner scanner) {
        String id = scanner.nextLine();
        String name = scanner.nextLine();
        String manu = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());
        double price = Double.parseDouble(scanner.nextLine());
        double weight = Double.parseDouble(scanner.nextLine());
        String date = scanner.nextLine();
        return new Motorbike(id, name, manu, quantity, price, weight, date);
    }

    public static void inputMotorbike (Scanner scanner, ArrayList<Motorbike> motorbikes, int n) {
        for (int i = 0; i < n; i++) {
            motorbikes.add(createMotorbike(scanner));
        }
    }
    public static void ouputMotorbike (ArrayList<Motorbike> motorbikes)
    {
        for (Motorbike motorbike : motorbikes) {
            motorbike.printMotorbike();
        }
    }

    public static ArrayList<Motorbike> search (String manu, ArrayList<Motorbike> motorbikes)
    {
        return motorbikes.stream()
                .filter(motorbike -> motorbike.getManu().equals(manu))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static ArrayList<Motorbike> maxWeight (ArrayList<Motorbike> motorbikes)
    {
        double max = motorbikes.get(0).getWeight();
        ArrayList<Motorbike> maxWeightMotorbikes = new ArrayList<>();
        maxWeightMotorbikes.add(motorbikes.get(0));
        for (Motorbike motorbike : motorbikes) {
            if (motorbike.getWeight() > max) {
                max = motorbike.getWeight();
                maxWeightMotorbikes.clear();
                maxWeightMotorbikes.add(motorbike);
            }
        }
        return maxWeightMotorbikes;
    }

    public static ArrayList<Motorbike> minQuanlity (ArrayList<Motorbike> motorbikes)
    {
        int min = motorbikes.get(0).getQuantity();
        ArrayList<Motorbike> minQuantityMotorBikes = new ArrayList<>();
        minQuantityMotorBikes.add(motorbikes.get(0));
        for (Motorbike motorbike : motorbikes) {
            if (motorbike.getQuantity() < min) {
                min = motorbike.getQuantity();
                minQuantityMotorBikes.clear();
                minQuantityMotorBikes.add(motorbike);
            }
        }
        return minQuantityMotorBikes;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayList<Motorbike> motorbikes = new ArrayList<>();
        inputMotorbike(scanner, motorbikes, n);
        int c = Integer.parseInt(scanner.nextLine());
        switch (c) {
            case 1:
                ouputMotorbike(search("Honda", motorbikes));
                break;
            case 2:
                ouputMotorbike(maxWeight(motorbikes));
                break;
            case 3:
                ouputMotorbike(minQuanlity(motorbikes));
                break;
            default:
                System.out.println("errrrrrrrrrrrrrrr");
        }
    }
}
