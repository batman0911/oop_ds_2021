package lesson_4.book;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by linhnm on September, 2021
 */

public class BookManagement {
    /* Thứ tự nhập
       +) Số lượng các cuốn sách

       +) 1 số nguyên 0 hoặc 1 (nếu 0 là sách tham khảo, 1 là sách giáo khoa)

       +)  id (mã sách), name (tên sách), quantity (số lượng), publisher (NXB), price (giá)

       +)  status (trạng thái) với sách giáo khoa,  tax (thuế) đối với sách tham khảo.
   */
    public Book[] readData(Scanner sc) {
        int n = Integer.parseInt(sc.nextLine());
        Book[] books = new Book[n];
        for (int i = 0; i < n; i++) {
            int type = Integer.parseInt(sc.nextLine());
            String id = sc.nextLine();
            String name = sc.nextLine();
            int quantity = Integer.parseInt(sc.nextLine());
            String publisher = sc.nextLine();
            double price = Double.parseDouble(sc.nextLine());
            if (type == 1) {
                boolean status = Boolean.parseBoolean(sc.nextLine());
                books[i] = new TextBook(id, name, quantity, publisher, price, status);
            } else if (type == 0) {
                double tax = Double.parseDouble(sc.nextLine());
                books[i] = new ReferenceBook(id, name, quantity, publisher, price, tax);
            }
        }
        return books;
    }

    // In thong tin các cuốn sách
    public void printBooks(Book[] books) {
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].toString());
        }
    }

    // Tìm các cuốn sách của nhà xuất bản publisher
    public ArrayList<Book> findBooks(Book[] books, String publisher) {
        ArrayList<Book> res = new ArrayList<>();
        for (int i = 0; i < books.length; i++) {
            if (books[i].getPublisher().equals(publisher)) res.add(books[i]);
        }
        return res;
    }

    // Tính giá trị trung bình của các cuốn sách thuộc thể loại typeOfBooks
    public double computeAverage(Book[] books, String typeOfBooks) {
        double avgText = 0;
        double avgRef = 0;
        int countText = 0;
        int countRef = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i] instanceof TextBook) {
                avgText += books[i].getAmount();
                countText++;
            } else if (books[i] instanceof ReferenceBook) {
                avgRef += books[i].getAmount();
                countRef++;
            }
        }

        if (typeOfBooks.equals("TextBook")) return avgText / countText;
        else if (typeOfBooks.equals("ReferenceBook")) return avgRef / countRef;

        return 0.0;
    }

    // Sắp xếp các cuốn sách tăng dần về giá tiền
    public void sortByPrice(Book[] books) {
        Book tmp;
        for (int i = 0; i < books.length; i++) {
            for (int j = 0; j < books.length - i - 1; j++) {
                if (books[j].getPrice() > books[j + 1].getPrice()) {
                    tmp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = tmp;
                }
            }
        }
        tmp = null;
    }

    public static void main(String[] args) {
    }
}
