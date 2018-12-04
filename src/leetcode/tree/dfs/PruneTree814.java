package leetcode.tree.dfs;

import leetcode.tree.TreeNode;

/**
 * Created by zhaiyi on 2018/12/4.
 */
public class PruneTree814 {

    /**
     * 方法一：累加子树和，容易想到，但并不是最快的
     * @param root
     * @return
     */
    public TreeNode pruneTree(TreeNode root) {
        int res = subTreeSum(root);
        if (res == 0) {
            return null;
        } else {
            return root;
        }
    }

    public int subTreeSum(TreeNode node) {
        if (node != null) {
            int left_sum = subTreeSum(node.left);
            int right_sum = subTreeSum(node.right);
            if (left_sum == 0) {
                node.left = null;
            }
            if (right_sum == 0) {
                node.right = null;
            }
            return node.val + left_sum + right_sum;
        } else {
            return 0;
        }
    }

    /**
     * 方法二：无需累加和
     * @param root
     * @return
     */
    public TreeNode pruneTree2(TreeNode root) {
        boolean res = subTree(root);

        return res ? root : null;
    }

    public boolean subTree(TreeNode node) {
        if (node == null) {
            return false;
        } else {
            //true表示要保留，false剪枝
            boolean left, right;
            left = subTree(node.left);
            if (!left) {
                node.left = null;
            }
            right = subTree(node.right);
            if (!right) {
                node.right = null;
            }
            return node.val != 0 || left || right;
        }
    }
}
