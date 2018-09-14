package leetcode.simple.tree.binary.bst;

import leetcode.simple.tree.binary.TreeNode;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]

         _______6______
        /              \
     ___2__          ___8__
    /      \        /      \
   0       4       7       9
  /  \
 3   5

 思路：利用二叉搜索树的特性，只要落在[p, q]之内就是最近公共祖先，否则递归左子树或右子树
 * Created by zhaiyi on 2018/9/6.
 */
public class SameAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return null;
        }
        return find(root, p.val, q.val);
    }

    public TreeNode find(TreeNode node, int p, int q) {
        if (node != null) {
            if (node.val < p && node.val < q) {
                return find(node.right, p, q);
            } else if (node.val > p && node.val > q) {
                return find(node.left, p, q);
            } else {
                return node;
            }
        } else {
            return null;
        }
    }
}
