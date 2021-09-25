package lesson_2;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by linhnm on September, 2021
 */

public class CountValues {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        int[] arr = new int[] {2, 3, 2, 7, 1, 2, 3, 7, 7, 2};

        for (int j : arr) {
            if (map.containsKey(j)) {
                map.put(j, map.get(j) + 1);
                continue;
            }
            map.put(j, 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.print(entry.getKey() + ":" + entry.getValue() + " ");
        }
    }
}
