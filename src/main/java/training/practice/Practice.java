package training.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

public class Practice {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        NotReduceArrayList<Integer> notReduceArrayList = new NotReduceArrayList<>();

        notReduceArrayList.addAll(Arrays.asList(4, 5, -6, 4, 5, 3, 4, 2, 4, 5, 7));

        notReduceArrayList.forEach(x -> {
                    if (map.containsKey(x)) {
                        map.put(x, map.get(x) + 1);
                    } else {
                        map.put(x, 1);
        }});

        System.out.println(map);
    }
}
