package leetcode.tree.binary.resursion;

import leetcode.tree.binary.TreeNode;

/**
 * 翻转一棵二叉树。

 示例：

 输入：

      4
    /   \
   2     7
  / \   / \
 1   3 6   9
 输出：

      4
    /   \
   7     2
  / \   / \
 9   6 3   1
 * Created by zhaiyi on 2018/9/6.
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    public void invert(TreeNode node) {
        if (node != null) {
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            invert(node.left);
            invert(node.right);
        }
    }
}
