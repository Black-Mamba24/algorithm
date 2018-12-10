package leetcode.tree.dfs;

import leetcode.tree.TreeNode;

/**
 * 在二叉树中增加一行
 * 给定一个二叉树，根节点为第1层，深度为 1。在其第 d 层追加一行值为 v 的节点。
 * 添加规则：给定一个深度值 d （正整数），针对深度为 d-1 层的每一非空节点 N，为 N 创建两个值为 v 的左子树和右子树。
 * 将 N 原先的左子树，连接为新节点 v 的左子树；将 N 原先的右子树，连接为新节点 v 的右子树。
 * 如果 d 的值为 1，深度 d - 1 不存在，则创建一个新的根节点 v，原先的整棵树将作为 v 的左子树。
 * 输入:
 * 二叉树如下所示:
 *        4
 *      /   \
 *     2     6
 *    / \   /
 *   3   1 5
 *
 * v = 1
 *
 * d = 2
 *
 * 输出:
 *        4
 *       / \
 *      1   1
 *     /     \
 *    2       6
 *   / \     /
 *  3   1   5
 */
public class AddOneRow623 {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        } else {
            add(root, 1, d, v);
            return root;
        }
    }

    public void add(TreeNode node, int deep, int target, int value) {
        if (node != null) {
            if (deep == target - 1) {
                {
                    TreeNode newNode = new TreeNode(value);
                    TreeNode tmp = node.left;
                    node.left = newNode;
                    newNode.left = tmp;
                }
                {
                    TreeNode newNode = new TreeNode(value);
                    TreeNode tmp = node.right;
                    node.right = newNode;
                    newNode.right = tmp;
                }
            } else if (deep < target - 1) {
                add(node.left, deep + 1, target, value);
                add(node.right, deep + 1, target, value);
            }
        }
    }
}
