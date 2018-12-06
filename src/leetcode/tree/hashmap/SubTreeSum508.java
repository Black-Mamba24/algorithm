package leetcode.tree.hashmap;

import leetcode.tree.TreeNode;

import java.util.*;

/**
 * 出现次数最多的子树元素和
 * 给出二叉树的根，找出出现次数最多的子树元素和。一个结点的子树元素和定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。然后求出出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的元素（不限顺序）。
 * 输入:
 *   5
 *  /  \
 * 2   -5
 * 返回 [2]，只有 2 出现两次，-5 只出现 1 次。
 */
public class SubTreeSum508 {
    public HashMap<Integer, Integer> map = new HashMap<>();
    public int max = -1;

    public int[] findFrequentTreeSum(TreeNode root) {
        find(root);
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                list.add(entry.getKey());
            }
        }
        int[] res = new int[list.size()];
        int i = 0;
        for (Integer r : list) {
            res[i++] = r;
        }
        return res;
    }

    public int find(TreeNode node) {
        if (node != null) {
            int left = find(node.left);
            int right = find(node.right);
            int sum = left + right + node.val;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            max = Math.max(max, map.get(sum));
            return sum;
        }
        return 0;
    }
}
