package leetcode.tree.bst;

import leetcode.tree.TreeNode;

/**
 * Created by zhaiyi on 2018/9/29.
 */
public class Insert701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        TreeNode tmp = root;
        insert(tmp, val);
        return root;
    }

    public void insert(TreeNode root, int val) {
        if (root != null) {
            if(root.val < val) {
                if (root.right == null) {
                    root.right = new TreeNode(val);
                    return;
                } else {
                    insert(root.right, val);
                }
            } else if (root.val > val) {
                if (root.left == null) {
                    root.left = new TreeNode(val);
                    return;
                } else {
                    insert(root.left, val);
                }
            }
        }
    }
}
