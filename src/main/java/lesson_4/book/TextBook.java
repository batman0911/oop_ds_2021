package lesson_4.book;

/**
 * Created by linhnm on September, 2021
 */

public class TextBook extends Book {
    private boolean status;

    public TextBook(String id, String name, int quantity, String publisher, double price, boolean status) {
        super(id, name, quantity, publisher, price);
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public double getAmount() {
        // TODO Auto-generated method stub
        return isStatus() ? super.getPrice() * super.getQuantity() : super.getPrice() * super.getQuantity() / 2.0;
    }

    @Override
    public String toString() {
        return "TextBook [status=" + status + ", getId()=" + getId() + ", getName()=" + getName() + ", getQuantity()="
                + getQuantity() + ", getPublisher()=" + getPublisher() + ", getPrice()=" + getPrice() + ", getAmount()="
                + getAmount() + "]";
    }
}
