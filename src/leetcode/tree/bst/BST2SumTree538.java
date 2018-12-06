package leetcode.tree.bst;

import leetcode.tree.TreeNode;

/**
 * 把二叉搜索树转换为累加树
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 * 输入: 二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 */
public class BST2SumTree538 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);
        BST2SumTree538 bst2SumTree538 = new BST2SumTree538();
        bst2SumTree538.convertBST(root);
    }

    public TreeNode convertBST(TreeNode root) {
        sum(root);
        return root;
    }

    int sum = 0;

    public void sum(TreeNode node) {
        if (node != null) {
            sum(node.right);
            sum += node.val;
            node.val = sum;
            sum(node.left);
        }
    }
}
