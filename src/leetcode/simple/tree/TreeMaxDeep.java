package leetcode.simple.tree;

/**
 * 给定一个二叉树，找出其最大深度。

 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

 说明: 叶子节点是指没有子节点的节点。
 * Created by zhaiyi on 2018/8/28.
 */
public class TreeMaxDeep {
    int max = 0;

    public int maxDepth(TreeNode root) {
        traverse(root, 0);
        return max;
    }

    public void traverse(TreeNode node, int deep) {
        if (node != null) {
            traverse (node.left, deep + 1);
            traverse (node.right, deep + 1);
        } else {
            max = Math.max(max,deep);
        }
    }
}
