package leetcode.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by zhaiyi on 2019/1/3.
 */
public class FrequencySort451 {
    /* 优先级队列+哈希表，并不是最优解，还可以用列表+排序 */
    public String frequencySort(String s) {
        PriorityQueue<Item> queue = new PriorityQueue<>(new Comparator<Item>() {
            @Override public int compare(Item o1, Item o2) {
                return o2.count - o1.count;
            }
        });
        Map<Character, Item> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                Item tmp = map.get(c);
                queue.remove(tmp);
                tmp.count++;
                queue.offer(tmp);
            } else {
                Item item = new Item(c, 1);
                queue.offer(item);
                map.put(c, item);
            }
        }
        StringBuilder res = new StringBuilder();
        while (!queue.isEmpty()) {
            Item item = queue.poll();
            for (int i = 0; i < item.count; i++) {
                res.append(item.key);
            }
        }
        return res.toString();
    }

    class Item {
        Character key;
        int count;

        Item(Character key, int count) {
            this.key = key;
            this.count = count;
        }
    }
}
