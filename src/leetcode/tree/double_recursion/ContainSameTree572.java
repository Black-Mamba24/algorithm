package leetcode.tree.double_recursion;

import leetcode.tree.TreeNode;

/**
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。

 示例 1:
 给定的树 s:

     3
    / \
   4   5
  / \
 1   2
 给定的树 t：

   4
  / \
 1   2
 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 思路：双递归法，先从s上找到头结点跟t相同的节点，作为子树开始判断是否为相同的数
 * Created by zhaiyi on 2018/9/20.
 */
public class ContainSameTree572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s, t);
    }

    public boolean traverse(TreeNode s, TreeNode t) {
        if (s != null) {
            if (s.val == t.val) {
                boolean r = isSameTree(s, t);
                if (r) {
                    return true;
                }
            }
            return traverse(s.left, t) || traverse(s.right, t);
        }
        return false;
    }

    public boolean isSameTree(TreeNode s, TreeNode t) {
        if (s != null && t != null) {
            return s.val == t.val && isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
        } else if (s == null && t == null) {
            return true;
        } else {
            return false;
        }
    }
}
