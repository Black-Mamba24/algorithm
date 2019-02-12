package leetcode.tree.hashmap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import leetcode.tree.TreeNode;

/**
 * 给定二叉树，按垂序遍历返回其结点值。
 对位于 (X, Y) 的每个结点而言，其左右子结点分别位于 (X-1, Y-1) 和 (X+1, Y-1)。
 把一条垂线从 X = -infinity 移动到 X = +infinity ，每当该垂线与结点接触时，我们按从上到下的顺序报告结点的值（ Y 坐标递减）。
 如果两个结点位置相同，则首先报告的结点值较小。
 按 X 坐标顺序返回非空报告的列表。每个报告都有一个结点值列表。
 * Created by zhaiyi on 2019/2/12.
 */
public class VerticalTraversal987 {
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
