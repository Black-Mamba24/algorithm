package leetcode.tree.iteration;

import leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ForwardTraverse144 {
    public static void main(String[] args) {
        ForwardTraverse144 forwardTraverse144 = new ForwardTraverse144();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        forwardTraverse144.preorderTraversal(root);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return res;
        } else {
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                res.add(node.val);
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
            return res;
        }
    }
}
