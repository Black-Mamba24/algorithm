package leetcode.tree.binary.bst;

import leetcode.tree.binary.TreeNode;

import java.util.Stack;

/**
 *
 说明：
 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。

 示例 1:

 输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
 \
  2
 输出: 1
 思路:二叉搜索树中序遍历是有序的
 * Created by zhaiyi on 2018/9/15.
 */
public class KthMin {
    public Stack<Integer> stack = new Stack<>();
    public int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        middleTraverse(root, k);
        return result;
    }

    public void middleTraverse(TreeNode node, int k) {
        if (node != null) {
            middleTraverse(node.left, k);
            stack.push(node.val);
            if (stack.size() == k) {
                result = stack.peek();
                return;
            }
            middleTraverse(node.right, k);
        }
    }
}
