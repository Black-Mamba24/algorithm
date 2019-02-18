package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import leetcode.tree.TreeNode;

public class Main4 {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        SortedMap<Integer, List<Item>> map = new TreeMap<>();
        mark(root, 0, 0, map);
        List<List<Integer>> res = new ArrayList<>();
        for (Map.Entry<Integer, List<Item>> entry : map.entrySet()) {
            Collections.sort(entry.getValue());
            List<Integer> list = new ArrayList<>();
            for (Item item : entry.getValue()) {
                list.add(item.val);
            }
            res.add(list);
        }
        return res;
    }

    public void mark(TreeNode node, int x, int y, SortedMap<Integer, List<Item>> map) {
        if (node != null) {
            if (!map.containsKey(x)) {
                map.put(x, new ArrayList<>());
            }
            map.get(x).add(new Item(node.val, y));
            mark(node.left, x - 1, y - 1, map);
            mark(node.right, x + 1, y - 1, map);
        }
    }

    class Item implements Comparable<Item> {
        int val;
        int y;

        Item(int val, int y) {
            this.val = val;
            this.y = y;
        }

        @Override public int compareTo(Item o) {
            if (o.y - y != 0) {
                return o.y - y;
            }
            return val - o.val;
        }
    }
}
