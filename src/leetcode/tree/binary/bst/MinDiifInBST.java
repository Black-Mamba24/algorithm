package leetcode.tree.binary.bst;

import leetcode.tree.binary.TreeNode;

/**
 * 给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。

 示例：

 输入: root = [4,2,6,1,3,null,null]
 输出: 1
 解释:
 注意，root是树结点对象(TreeNode object)，而不是数组。

 给定的树 [4,2,6,1,3,null,null] 可表示为下图:

      4
    /   \
   2     6
  / \
 1   3

 最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。

 思路：看到任意两个节点就是双递归法，第一层递归遍历树，第二层递归以第一层所有节点为头结点再遍历树，时间复杂度为O(nlogn)
 * Created by zhaiyi on 2018/9/15.
 */
public class MinDiifInBST {
    public long min = Long.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        traverse(root);
        return (int) min;
    }

    public void traverse(TreeNode node) {
        if (node != null) {
            find(node, node.val);
            traverse(node.left);
            traverse(node.right);
        }
    }

    public void find(TreeNode node, int tar) {
        if (node != null) {
            if (node.right != null) {
                min = Math.min(min, Math.abs(tar - node.right.val));
            }
            if (node.left != null) {
                min = Math.min(min, Math.abs(tar - node.left.val));
            }
            find(node.left, tar);
            find(node.right, tar);
        }
    }
}
