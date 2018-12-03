package leetcode;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.minIncrementForUnique(new int[]{3,2,1,2,1,7}));
    }

    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int len = A.length;
        SortedMap<Integer, Integer> map = new TreeMap<>();
        Map<Integer,Integer> newMap = new HashMap<>();
        for (int i : A) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int res = 0;
        int right;
        right = map.firstKey();
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();

            if (entry.getValue() == 1) {
                newMap.put(entry.getKey(), entry.getValue());
            } else {
                for (int i = 0; i < entry.getValue(); i++) {
                    while (newMap.containsKey(right)) {
                        right ++;
                    }
                    newMap.put(right, 1);
                    res += (right - entry.getKey());
                }
            }
        }
        return res;
    }
}