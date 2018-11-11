package leetcode.tree.bst;

import leetcode.tree.TreeNode;

/**
 * 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
 * 二叉搜索树保证具有唯一的值。
 */
public class BSTSum938 {
    public int sum = 0;

    public int rangeSumBST(TreeNode root, int L, int R) {
        traverse(root, L, R);
        return sum;
    }

    public void traverse(TreeNode root, int L, int R) {
        if (root != null) {
            int val = root.val;
            if (val < L) {
                traverse(root.right, L, R);
            } else if (val > R) {
                traverse(root.left, L, R);
            } else if (val == L) {
                sum += val;
                traverse(root.right, L, R);
            } else if (val == R) {
                sum += val;
                traverse(root.left, L, R);
            } else {
                sum += val;
                traverse(root.left, L, R);
                traverse(root.right, L, R);
            }
        }
    }
}
