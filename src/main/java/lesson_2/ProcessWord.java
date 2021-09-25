package lesson_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by linhnm on September, 2021
 */

public class ProcessWord {
    public static String[]  splitWords(String str){
        /* Hoàn thành phương thức để:
        Loại bỏ các ký tự trồng ở 2 đầu xâu, các khoảng trống liên tiếp
        ở giữa xâu thì chỉ được để lại 01 khoảng trống. Sau đó tách các "từ" -
        tức là các cụm ký tự liên tiếp không chứa khoảng trống, đưa vào một mảng
        các xâu. Trả lại là mảng các xâu đó */
        return str.trim().replaceAll("\\s+", " ").split(" ");
    }

    public static void listMaxLength(String[] listWords){
        /* Hoàn thành phương thức để:
        Tìm và in ra các phần tử (xâu) có độ dài lớn nhất trong mảng các xâu listWords
        trên 01 dòng, các phần tử cách nhau bởi đúng 01 khoảng trống.
        Sau khi in xong cần xuống dòng.*/
        int length = listWords[0].length();
        List<String> res = new ArrayList<>();
        res.add(listWords[0]);

        for (int i = 1; i < listWords.length; i++) {
            if (listWords[i].length() > res.get(res.size() - 1).length()) {
                res.clear();
                res.add(listWords[i]);
            } else if (listWords[i].length() == res.get(res.size() - 1).length()) {
                res.add(listWords[i]);
            }
        }
        for (String str : res) {
            System.out.print(str + " ");
        }
        System.out.println();
    }

    public static void  sortListWords(String[] listWords){
        /*hoàn thành phương thức sắp xếp các phần tử  trong mảng các xâu listWords tăng dần theo thứ tự từ điển */
        Arrays.sort(listWords);
        for (String str : listWords) {
            System.out.print(str + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String[] res = splitWords("hello   dai ca Linh  words");
        for (String str : res) {
            System.out.print(str + "\n");
        }

        listMaxLength(res);
        sortListWords(res);
    }
}
