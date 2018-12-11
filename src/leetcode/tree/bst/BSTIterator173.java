package leetcode.tree.bst;

import leetcode.tree.TreeNode;

import java.util.Stack;

/**
 * 二叉搜索树迭代器
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 * 注意: next() 和hasNext() 操作的时间复杂度是O(1)（错的），并使用 O(h) 内存，其中 h 是树的高度。
 */
public class BSTIterator173 {
    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator173(TreeNode root) {
        if (root != null) {
            TreeNode cur = root;
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
        }
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * @return the next smallest number这个并不是O(1)但题目要求O(1)
     */
    public int next() {
        if (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode cur = node.right;
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            return node.val;
        } else {
            return 0;
        }
    }
}
