package leetcode.simple.tree;

/**
 * Created by zhaiyi on 2018/9/7.
 */
public class LeftNodeSum {
    int result = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return result;
        } else {
            findLeft(root, false);
            return result;
        }
    }

    public void findLeft(TreeNode node, boolean isLeft) {
        if (node.left == null && node.right == null && isLeft) {
            result += node.val;
        } else {
            if (node.left != null) {
                findLeft(node.left, true);
            }
            if (node.right != null) {
                findLeft(node.right, false);
            }
        }
    }
}
