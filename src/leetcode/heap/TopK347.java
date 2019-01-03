package leetcode.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by zhaiyi on 2019/1/3.
 */
public class TopK347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        PriorityQueue<Item> queue = new PriorityQueue<>(new Comparator<Item>() {
            @Override public int compare(Item o1, Item o2) {
                return o2.count - o1.count;
            }
        });
        HashMap<Integer, Item> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                Item tmp = map.get(num);
                queue.remove(tmp);
                tmp.count++;
                queue.offer(tmp);
            } else {
                Item item = new Item(num, 1);
                queue.offer(item);
                map.put(num, item);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(queue.poll().num);
        }
        return res;
    }

    class Item {
        int num;
        int count;

        Item(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
}
