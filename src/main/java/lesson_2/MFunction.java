package lesson_2;

import java.util.Arrays;
import java.util.List;

/**
 * Created by linhnm on September, 2021
 */

public class MFunction {
    public static int sum(int[] a)
    {
        int sum = 0;
        for (int j : a) {
            sum += j;
        }
        return sum;
    }

    public static int maxOdd(int[] a)
    {
        int maxOdd = -1;
        for (int j : a) {
            if (j % 2 != 0) {
                maxOdd = Math.max(maxOdd, j);
            }
        }
        return maxOdd;
    }

    public static int minEven (int[] a)
    {
        int minEven = 0;
        for (int j : a) {
            if (j % 2 == 0) {
                minEven = j;
                break;
            }
        }
        for (int j : a) {
            if (j % 2 == 0) {
                minEven = Math.min(minEven, j);
            }
        }
        return minEven == 0 ? -1 : minEven;
    }

    public static boolean isCharContain(String s)
    {
        List<Character> characterList = Arrays.asList('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z');
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (characterList.contains(c)) return true;
        }
        return false;
    }

    public static boolean isNumContain(String s)
    {
        List<Character> numList = Arrays.asList('0','1','2','3','4','5','6','7','8','9');
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (numList.contains(c)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        List<Character> characterList = Arrays.asList('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z');
        List<Integer> numList = Arrays.asList(0,1,2,3,4,5,6,7,8,9);

        System.out.println("Tong cac phan tu trong mang la: "+sum(a));

        System.out.println("So le lon nha la: "+maxOdd(a));

        System.out.println("So chan mho nha la: "+minEven(a));

        String s = "a123abcbsbasdcaac3ABCXaxddsa";

        if(isCharContain(s))
            System.out.println("Xau co chua chu cai");
        else
            System.out.println("Xau khong chua chu cai");

        if(isNumContain(s))
            System.out.println("Xau co chua chu so");
        else
            System.out.println("Xau khong chua chu so");


    }
}
