package leetcode.simple.tree.binary.simple_resursion;

import leetcode.simple.tree.binary.TreeNode;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。

 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     1
    / \
   2   2
  / \ / \
 3  4 4  3
 思路：同时递归左右子树
 * Created by zhaiyi on 2018/8/28.
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return traverse(root.left, root.right);
    }

    public boolean traverse(TreeNode left, TreeNode right) {
        if (left != null && right != null) {
            return left.val == right.val && traverse(left.left, right.right) && traverse(left.right, right.left);
        } else return left == null && right == null;
    }
}
