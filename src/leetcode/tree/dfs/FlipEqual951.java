package leetcode.tree.dfs;

import leetcode.tree.TreeNode;

/**
 * 翻转等价二叉树
 * 我们可以为二叉树 T 定义一个翻转操作，如下所示：选择任意节点，然后交换它的左子树和右子树。
 * 只要经过一定次数的翻转操作后，能使 X 等于 Y，我们就称二叉树 X 翻转等价于二叉树 Y。
 * 编写一个判断两个二叉树是否是翻转等价的函数。这些树由根节点 root1 和 root2 给出。
 *
 * 思路：典型深度遍历思想，判断当前节点是否相等，如果翻转相等则翻转tree2，继续深度遍历比较
 */
public class FlipEqual951 {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 != null && root2 != null) {
            TreeNode left1 = root1.left;
            TreeNode right1 = root1.right;
            TreeNode left2 = root2.left;
            TreeNode right2 = root2.right;
            //如果翻转相等，则翻转tree2
            if (nodeEquals(left1, right2) && nodeEquals(right1, left2)) {
                TreeNode tmp = left2;
                left2 = right2;
                right2 = tmp;
            }
            return nodeEquals(left1, left2) && nodeEquals(right1, right2) &&
                    flipEquiv(left1, left2) && flipEquiv(right1, right2);
        }
        return root1 == null && root2 == null;
    }

    public boolean nodeEquals(TreeNode node1, TreeNode node2) {
        return (node1 == null && node2 == null) || (node1 != null && node2 != null && node1.val == node2.val);
    }
}
