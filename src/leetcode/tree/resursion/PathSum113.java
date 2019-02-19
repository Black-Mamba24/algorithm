package leetcode.tree.resursion;

import java.util.ArrayList;
import java.util.List;
import leetcode.tree.TreeNode;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class PathSum113 {
    public static void main(String[] args) {
        PathSum113 pathSum113 = new PathSum113();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(-2);
        root.left.left.left = new TreeNode(-1);
        pathSum113.pathSum(root, 2);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        find(root, 0, sum, new ArrayList<>(), res);
        return res;
    }

    public void find(TreeNode node, int sum, int target, List<Integer> list, List<List<Integer>> res) {
        if (node != null) {
            if (node.left == null && node.right == null && sum + node.val == target) {
                List<Integer> l = new ArrayList<>(list);
                l.add(node.val);
                res.add(l);
            } else {
                list.add(node.val);
                find(node.left, sum + node.val, target, list, res);
                find(node.right, sum + node.val, target, list, res);
                list.remove(list.size() - 1);
            }
        }
    }
}
