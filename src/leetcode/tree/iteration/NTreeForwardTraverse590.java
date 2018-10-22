package leetcode.tree.iteration;

import leetcode.tree.resursion.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个 N 叉树，返回其节点值的前序遍历。使用迭代法。
 *
 * 思路：栈
 * Created by zhaiyi on 2018/10/14.
 */
public class NTreeForwardTraverse590 {
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return new ArrayList();
        }
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(node.val);
            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.push(node.children.get(i));
            }
        }
        return res;
    }
}