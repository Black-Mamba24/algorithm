package leetcode.greedy;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * Created by zhaiyi on 2018/9/26.
 */
public class Schedule {
    public static void main(String[] args) {
        Schedule schedule = new Schedule();
        System.out.println(schedule.leastInterval(new char[]{'A', 'A', 'C', 'B', 'B', 'C'}, 3));
    }

    public int leastInterval(char[] tasks, int n) {
//        if (tasks.length == 0) {
//            return 0;
//        }
//        Map<Character, Integer> map = new HashMap<>();
//        Queue<Character> queue = new ArrayDeque<>();
//        int count = 0, time = 0;
//        char last = 0;
//        for (char c : tasks) {
//            queue.offer(c);
//        }
//        while (!queue.isEmpty()) {
//            char c = queue.poll();
//            count++;
//            if (c != last || n == 0) {
//                if (!map.containsKey(c) || count - map.get(c) > n) {
//                    last = c;
//                    map.put(c, count);
//                    System.out.println(c);
//                } else {
//                    queue.offer(c);
//                    for (Map.Entry entry : map.)
//                    System.out.println("wait");
//                }
//                time++;
//            } else {
//                queue.offer(c);
//            }
//        }
//        return time;
        return 0;
    }
}
