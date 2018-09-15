package leetcode.tree.binary.simple_resursion;

import leetcode.tree.binary.TreeNode;

/**
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。

 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。

 示例 1:

 输入:
     2
    / \
   2   5
  / \
 5   7

 输出: 5
 说明: 最小的值是 2 ，第二小的值是 5 。

 思路：简单的遍历，跟求数组中第三大的题目有相似性，小技巧：public long f = Long.MAX_VALUE, s = Long.MAX_VALUE;代码简洁，减少判断次数
 * Created by zhaiyi on 2018/9/15.
 */
public class SecondMin {
    public long f = Long.MAX_VALUE, s = Long.MAX_VALUE;
    public int findSecondMinimumValue(TreeNode root) {
        traverse(root);
        return s == Long.MAX_VALUE ?  -1 : (int)s;
    }

    public void traverse(TreeNode node) {
        if (node != null) {
            if (node.val < f) {
                s = f;
                f = node.val;
            } else if (node.val < s && node.val > f) {
                s = node.val;
            }
            traverse(node.left);
            traverse(node.right);
        }
    }
}
