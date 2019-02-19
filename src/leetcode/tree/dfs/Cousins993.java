package leetcode.tree.dfs;

import leetcode.tree.TreeNode;

/**
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。

 如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。

 我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。

 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。
 * Created by zhaiyi on 2019/2/17.
 */
public class Cousins993 {
    public static void main(String[] args) {

    }

    public boolean isCousins(TreeNode root, int x, int y) {
        int xd = deep(root, x, 0);
        int yd = deep(root, y, 0);
        if (xd == yd) {
            TreeNode xp = parent(root, null, x);
            TreeNode yp = parent(root, null, y);
            return xp != yp;
        }
        return false;
    }

    public int deep(TreeNode node, int target, int deep) {
        if (node != null) {
            if (node.val == target) {
                return deep;
            } else {
                return deep(node.left, target, deep + 1) + deep(node.right, target, deep + 1);
            }
        }
        return 0;
    }

    public TreeNode parent(TreeNode node, TreeNode p, int target) {
        if (node != null) {
            if (node.val == target) {
                return p;
            } else {
                TreeNode left = parent(node.left, node, target);
                TreeNode right = parent(node.right, node, target);
                if (left == null) {
                    return right;
                } else {
                    return left;
                }
            }
        }
        return null;
    }
}
