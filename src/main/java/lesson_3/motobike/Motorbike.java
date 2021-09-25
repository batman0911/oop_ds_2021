package lesson_3.motobike;

/**
 * Created by linhnm on September, 2021
 */

public class Motorbike {
    private String id;
    private String name;
    private String manu;
    private int quantity;
    private double price;
    private double weight;
    private String date;

    public void printMotorbike() {
        System.out.println(id + " " + name + " " + manu + " " + quantity + " " + price + " " + weight + " " + date);
    }

    public Motorbike(String id, String name, String manu, int quantity, double price, double weight, String date) {
        this.id = id;
        this.name = name;
        this.manu = manu;
        this.quantity = quantity;
        this.price = price;
        this.weight = weight;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManu() {
        return manu;
    }

    public void setManu(String manu) {
        this.manu = manu;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
