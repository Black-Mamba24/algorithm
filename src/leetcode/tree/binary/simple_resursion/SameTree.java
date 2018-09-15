package leetcode.tree.binary.simple_resursion;

import leetcode.tree.binary.TreeNode;

/**
 *给定两个二叉树，编写一个函数来检验它们是否相同。

 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * Created by zhaiyi on 2018/8/28.
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return traverse(p, q);
    }

    public boolean traverse(TreeNode p, TreeNode q) {
        if (p != null && q != null) {
            if (p.val == q.val) {
                return traverse(p.left, q.left) && traverse(p.right, q.right);
            } else {
                return false;
            }
        } else if (p == null && q == null) {
            return true;
        } else {
            return false;
        }
    }
}
