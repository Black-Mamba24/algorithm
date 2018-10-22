package leetcode.tree.resursion;

import leetcode.tree.TreeNode;

/**
 * 计算给定二叉树的所有左叶子之和。

 示例：

     3
    / \
   9  20
  /  \
 15   7

 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24

 思路：简单递归，递归参数为是否为左子树
 * Created by zhaiyi on 2018/9/7.
 */
public class LeftNodeSum {
    int result = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return result;
        } else {
            findLeft(root, false);
            return result;
        }
    }

    public void findLeft(TreeNode node, boolean isLeft) {
        if (node.left == null && node.right == null && isLeft) {
            result += node.val;
        } else {
            if (node.left != null) {
                findLeft(node.left, true);
            }
            if (node.right != null) {
                findLeft(node.right, false);
            }
        }
    }
}
