package leetcode.tree.binary.iteration;

import leetcode.tree.binary.resursion.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个 N 叉树，返回其节点值的后序遍历。迭代法
 *
 * 思路：列表中顺序为头、右、左，且节点的顺序也是反的，所以将列表翻转过来就是后续遍历，采用链表addFirst方式避免翻转
 * Created by zhaiyi on 2018/10/14.
 */
public class NtreeBackwardTraverse429 {
    public List<Integer> postorder(Node root) {
        if (root == null) {
            return new ArrayList();
        }
        LinkedList<Integer> res = new LinkedList<>();
        Stack<Node> stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node node = stack.pop();
            res.addFirst(node.val);
            for (int i = 0; i < node.children.size(); i++) {
                stack.push(node.children.get(i));
            }
        }

        return res;
    }
}
