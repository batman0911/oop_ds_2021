package lesson_4.car;

/**
 * Created by linhnm on September, 2021
 */

public class SportCar extends Car {
    private double tax;

    public SportCar(String id, String name, String manufacturer, double hours, double price, double tax) {
        super(id, name, manufacturer, hours, price);
        this.tax = tax;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    // Hoàn thiện phương thức getAmount() trả về giá thành tiền trong lớp SportCar
    @Override
    public double getAmount() {
        return super.getPrice() * super.getHours() + (super.getPrice() * super.getHours()) * this.tax / 100.0;
    }

    @Override
    public String toString() {
        return "SportCar [id=" + getId() + ", name=" + getName() + ", manufacturer=" + getManufacturer() + ", hours=" + getHours() + ", price="
                + getPrice() + ", tax = " + tax + "]";
    }
}
