package leetcode.tree.iteration;

import leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by zhaiyi on 2018/10/17.
 */
public class IterationTraverse {
//    public List<Integer> preorder(TreeNode root) {
//
//    }
//
//    public List<Integer> postorder(TreeNode root) {
//
//    }

    public List<Integer> inorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while (true) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                if (stack.isEmpty()) {
                    return list;
                }
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
    }
}
