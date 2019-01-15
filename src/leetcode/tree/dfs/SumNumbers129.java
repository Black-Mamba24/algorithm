package leetcode.tree.dfs;

import leetcode.tree.TreeNode;

/**
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 * 计算从根到叶子节点生成的所有数字之和。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 1
 * / \
 * 2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 */
public class SumNumbers129 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        SumNumbers129 sumNumbers129 = new SumNumbers129();
        System.out.println(sumNumbers129.sumNumbers(root));
    }

    public int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 0);
        return sum;
    }

    public void dfs(TreeNode node, int s) {
        s = s * 10 + node.val;
        if (node.left == null && node.right == null) {
            sum += s;
        } else {
            if (node.left != null) {
                dfs(node.left, s);
            }
            if (node.right != null) {
                dfs(node.right, s);
            }
        }
    }
}