package leetcode.tree.bst;

import leetcode.tree.TreeNode;

/**
 * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。

 案例 1:

 输入:
     5
    / \
   3   6
  / \   \
 2   4   7

 Target = 9

 输出: True
 思路：这道题发现要任意两个数的和，因此时间复杂度为O(nlogn)，每个节点都要作为root节点遍历子树。因此即两次递归
 * Created by zhaiyi on 2018/9/14.
 */
public class TwoNumSum {
    public boolean findTarget(TreeNode root, int k) {
        find (root, root, k);
        return result;
    }
    public boolean result;
    public void find(TreeNode root, TreeNode node, int target) {
        if (node != null) {
            if (find_(root, node, target - node.val)) {
                result = true;
                return;
            } else {
                find(root, node.left, target);
                find(root, node.right, target);
            }
        }
    }

    public boolean find_(TreeNode root, TreeNode node, int t) {
        if (root != null) {
            if (root == node) {
                return find_(root.left, node, t) || find_(root.right, node, t);
            } else {
                if (root.val == t) {
                    return true;
                } else if (root.val > t) {
                    return find_(root.left, node, t);
                } else {
                    return find_(root.right, node, t);
                }
            }
        } else {
            return false;
        }
    }
}
