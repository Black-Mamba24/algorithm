package leetcode.tree.dfs;

import leetcode.tree.TreeNode;

public class Tilt563 {
    /**
     * 方法一：很差的方法，每个节点都递归算，能通过
     */
    public int sum = 0;

    public int findTilt(TreeNode root) {
        if (root != null) {
            int left = sum(root.left);
            int right = sum(root.right);
            sum += Math.abs(left - right);
            findTilt(root.left);
            findTilt(root.right);
        } else {
            return 0;
        }
        return sum;
    }

    public int sum(TreeNode node) {
        int s = 0;
        if (node != null) {
            s += (node.val + sum(node.left) + sum(node.right));
        }
        return s;
    }

    /**
     *从下往上累加子树和
     */
    public int sum2 = 0;

    public int findTilt2(TreeNode root) {
        kkk(root);
        return sum2;
    }

    public int kkk(TreeNode root) {
        if (root != null) {
            int left = kkk(root.left);
            int right = kkk(root.right);
            sum2 += Math.abs(left - right);
            return left + right + root.val;
        } else {
            return 0;
        }
    }
}
