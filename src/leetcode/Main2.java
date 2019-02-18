package leetcode;

import leetcode.tree.TreeNode;

public class Main2 {
    public String min = null;

    public String smallestFromLeaf(TreeNode root) {
        find(root, "");
        return min;
    }

    public void find(TreeNode node, String cur) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                cur = (char) ('a' + node.val) + cur;
                if (min == null || cur.compareTo(min) < 0) {
                    min = cur;
                }
            } else {
                find(node.left, (char) ('a' + node.val) + cur);
                find(node.right, (char) ('a' + node.val) + cur);
            }
        }
    }
}
