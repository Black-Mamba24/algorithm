package leetcode.tree.dfs;

import leetcode.tree.TreeNode;

/**
 * 给定一颗根结点为 root 的二叉树，书中的每个结点都有一个从 0 到 25 的值，分别代表字母 'a' 到 'z'：值 0 代表 'a'，值 1 代表 'b'，依此类推。
 找出按字典序最小的字符串，该字符串从这棵树的一个叶结点开始，到根结点结束。
 （小贴士：字符串中任何较短的前缀在字典序上都是较小的：例如，在字典序上 "ab" 比 "aba" 要小。叶结点是指没有子结点的结点。）
 * Created by zhaiyi on 2019/2/12.
 */
public class SmallestFromLeaf988 {
    public String min = null;

    public String smallestFromLeaf(TreeNode root) {
        find(root, "");
        return min;
    }

    public void find(TreeNode node, String cur) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                cur = (char) ('a' + node.val) + cur;
                if (min == null || cur.compareTo(min) < 0) {
                    min = cur;
                }
            } else {
                find(node.left, (char) ('a' + node.val) + cur);
                find(node.right, (char) ('a' + node.val) + cur);
            }
        }
    }
}
