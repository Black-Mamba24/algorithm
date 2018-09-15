package leetcode.tree.binary.simple_resursion;

import leetcode.tree.binary.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。

 说明: 叶子节点是指没有子节点的节点。

 示例:

 输入:

    1
  /   \
 2     3
  \
  5

 输出: ["1->2->5", "1->3"]

 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 * Created by zhaiyi on 2018/9/7.
 */
public class AllPathFromRoot {
    List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return result;
        } else {
            findPath(root, "");
            return result;
        }
    }

    public void findPath(TreeNode node, String k) {
        if (node.left == null && node.right == null) {
            result.add(k+node.val);
        } else {
            if (node.left != null) {
                findPath (node.left, k+node.val+"->");
            }
            if (node.right != null) {
                findPath (node.right, k+node.val+"->");
            }
        }
    }
}
