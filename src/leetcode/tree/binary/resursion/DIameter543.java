package leetcode.tree.binary.resursion;

import leetcode.tree.binary.TreeNode;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。

 示例 :
 给定二叉树

     1
    / \
   2   3
  / \
 4   5
 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。

 注意：两结点之间的路径长度是以它们之间边的数目表示。

 思路：开始用双递归法也解决了问题，但速度慢。下面这个方法相当于从叶子节点开始累加，取每个节点的直径并取最大值，而非从上之下逐个节点递归
 * Created by zhaiyi on 2018/10/2.
 */
public class DIameter543 {
    public int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDeep(root);
        return max;
    }

    public int maxDeep(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = maxDeep(node.left);
        int right = maxDeep(node.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}
