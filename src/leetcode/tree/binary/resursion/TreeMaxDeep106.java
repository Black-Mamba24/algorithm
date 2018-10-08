package leetcode.tree.binary.resursion;

import leetcode.tree.binary.TreeNode;

/**
 * 给定一个二叉树，找出其最大深度。

 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

 说明: 叶子节点是指没有子节点的节点。
 * Created by zhaiyi on 2018/8/28.
 */
public class TreeMaxDeep106 {
    int max = 0;

    //方法一：
//    public int maxDepth(TreeNode root) {
//        traverse(root, 0);
//        return max;
//    }
//
//    public void traverse(TreeNode node, int deep) {
//        if (node != null) {
//            traverse (node.left, deep + 1);
//            traverse (node.right, deep + 1);
//        } else {
//            max = Math.max(max,deep);
//        }
//    }

    //方法二：更通用，更适合其他变种
    public int maxDepth(TreeNode root) {
        return maxDeep(root);
    }

    public int maxDeep(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = maxDeep(node.left);
        int right = maxDeep(node.right);
        return Math.max(left, right) + 1;
    }
}


/**
 * 给定一个N叉树，找到其最大深度。

 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。

 思路：思路与上面方法二相同
 */
class NTreeMaxDeep559 {
    public int maxDepth(Node root) {
        return maxDeep(root);
    }

    public int maxDeep(Node node) {
        if (node == null) {
            return 0;
        }
        int max = 0;
        for (Node no : node.children) {
            max = Math.max(max, maxDepth(no));
        }
        return max + 1;
    }
}