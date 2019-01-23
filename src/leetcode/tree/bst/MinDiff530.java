package leetcode.tree.bst;

import java.util.ArrayList;
import java.util.List;
import leetcode.tree.TreeNode;

public class MinDiff530 {
    /**
     * 方法一：中序遍历，再遍历列表
     */
//    public int getMinimumDifference(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        find(root, list);
//        if (list.size() <= 1) {
//            return 0;
//        }
//        int min = Integer.MAX_VALUE;
//        for (int i = 1; i < list.size(); i++) {
//            min = Math.min(min, list.get(i) - list.get(i - 1));
//        }
//        return min;
//    }
//
//    public void find(TreeNode node, List<Integer> list) {
//        if (node != null) {
//            find(node.left, list);
//            list.add(node.val);
//            find(node.right, list);
//        }
//    }

    /**
     * 方法二：中序遍历的优化，只记录last的值，最优解
     */
    public int last = 0;
    public int min = Integer.MAX_VALUE;
    public boolean first = true;

    public int getMinimumDifference(TreeNode root) {
        if (root != null) {
            getMinimumDifference(root.left);
            if (!first) {
                min = Math.min(min, root.val - last);
            }
            first = false;
            last = root.val;
            getMinimumDifference(root.right);
        }
        return min;
    }

}
