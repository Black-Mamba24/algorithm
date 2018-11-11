package leetcode.tree.double_recursion;

import leetcode.tree.TreeNode;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。

 本题中，一棵高度平衡二叉树定义为：
 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。

    3
   / \
  9  20
  /  \
 15   7
 true

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
 false
 需要理清思路，如果发现需要在一个函数中既返回高度，又返回是否平衡，需要分成两个函数，一个单独算高度，一个递归算是否平衡
 这道题的难点在于并非遍历一遍就能解决问题，每次递归都计算了当前节点左右子树的高度，如果不满足，则分别计算左子树的左右子树和右子树的左右子树
 只有当每个节点的左右子树高度相差都小于1时才算完成

 另外树的高度可以这样计算也可以按TreeMaxDeep计算
 * Created by zhaiyi on 2018/8/29.
 */
public class JudgeBalancedTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left_deep = deep(root.left);
        int right_deep = deep(root.right);
        if (Math.abs(left_deep - right_deep) > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public int deep(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int left_deep = 1 + deep(node.left);
            int right_deep = 1 + deep(node.right);
            return Math.max(left_deep, right_deep);
        }
    }
}
