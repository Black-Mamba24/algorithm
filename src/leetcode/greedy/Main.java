package leetcode.greedy;

import java.util.*;

/**
 * Created by zhaiyi on 2018/9/29.
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'C', 'D', 'D', 'A'}, 2));
    }

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        List<Character> available = new ArrayList<>();
        List<Character> unavailable = new ArrayList<>();
        List<Character> priority = new ArrayList<>();
        Map<Character, Integer> stepMap = new HashMap<>();

        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        available.addAll(map.keySet());

        int step = 0;

        while (!available.isEmpty() || !unavailable.isEmpty() || !priority.isEmpty()) {
            boolean need = true;
            {
                // priority
                if (!priority.isEmpty()) {
                    char c = priority.get(0);
                    if (map.get(c) == 0) {
                        priority.remove(0);
                    } else {
                        map.put(c, map.get(c) - 1);
                        System.out.println(c);
                        step++;
                        priority.remove(0);
                        if (unavailable.contains(c)) {
                            unavailable.add(c);
                        }
                        need = false;
                        stepMap.put(c, step + n);
                    }
                }
            }

            {
                // available
                if (need && !available.isEmpty()) {
                    int i = 0;
                    for (; i < available.size(); i++) {
                        char c = available.get(i);
                        if (map.get(c) == 0) {
                            available.remove(i);
                        } else {
                            map.put(c, map.get(c) - 1);
                            System.out.println(c);
                            step++;
                            stepMap.put(c, step + n);
                            break;
                        }
                    }
                    if (i == available.size()) {
                        System.out.println("待命");
                        step++;
                    }
                }
            }

            {
                // unavailable
                for (Map.Entry<Character, Integer> entry : stepMap.entrySet()) {
                    char c = entry.getKey();
                    if (step > entry.getValue()) {
                        if (!priority.contains(c)) {
                            priority.add(c);
                        }
                        unavailable.remove(c);
                    }
                }
            }
        }

        return step;
    }
}
