import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by zhaiyi on 2018/12/16.
 */
public class Test {
    public static void main(String[] args) {
//        PriorityQueue<Item> queue = new PriorityQueue<>();
//        int[] values = new int[] {0, 100, 2, 101, 102, 3, 4, 103, 104, 105, 106, 5, 6};
//        Item[] items = new Item[values.length];
//
//        for (int i = 0; i < values.length; i++) {
//            Item item = new Item(values[i]);
//            items[i] = item;
//            queue.offer(item);
//        }
//        queue.remove(items[1]);
        TreeMap <Integer, Integer> map = new TreeMap<>();
        int[] nums = new int[] {10,6,13,3,8,12,15};
        for (int i = 0; i < nums.length; i ++) {
            map.put(nums[i], i);
        }
        map.lowerKey(10);
//        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
//        TreeMap<Integer, Integer> newMap = new TreeMap<>(map);
    }
}

class Item implements Comparable<Item> {
    int i = 0;

    public Item(int i) {
        this.i = i;
    }

    @Override public int compareTo(Item o) {
        return i - o.i;
    }
}
