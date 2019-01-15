package leetcode.tree.resursion;

import leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleFBT894 {
    public static void main(String[] args) {
        AllPossibleFBT894 allPossibleFBT894 = new AllPossibleFBT894();
        allPossibleFBT894.allPossibleFBT(2);
    }

    public List<TreeNode> allPossibleFBT(int N) {
        TreeNode root = new TreeNode(0);
        List<TreeNode> res = new ArrayList<>();
        if (N % 2 == 0) {
            return res;
        }
        build(N - 1, res, root, null);
        return res;
    }

    public void build(int remain, List<TreeNode> res, TreeNode root, TreeNode node) {
        if (remain == 0) {
            res.add(copy(root));
        } else {
            if (node == null) {
                root.left = new TreeNode(0);
                root.right = new TreeNode(0);
                build(remain - 2, res, root, root.left);
                build(remain - 2, res, root, root.right);
            } else {
                node.left = new TreeNode(0);
                node.right = new TreeNode(0);
                build(remain - 2, res, root, node.left);
                build(remain - 2, res, root, node.right);
            }
        }
    }

    public TreeNode copy(TreeNode origin) {
        if (origin != null) {
            TreeNode root = new TreeNode(0);
            root.left = copy(origin.left);
            root.right = copy(origin.right);
            return root;
        }
        return null;
    }


}
