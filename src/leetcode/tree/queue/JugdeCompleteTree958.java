package leetcode.tree.queue;

import leetcode.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 二叉树的完全性检验
 * 给定一个二叉树，确定它是否是一个完全二叉树。
 * 百度百科中对完全二叉树的定义如下：
 * 若设二叉树的深度为 h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。（注：第 h 层可能包含 1~ 2h 个节点。）
 * 思路：层次遍历。只要出现任意的节点右孩子或左右孩子为空，则后面所有节点不能有孩子
 */
public class JugdeCompleteTree958 {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root == null) {
            return true;
        }
        queue.offer(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (flag) {
                    if (node.left != null && node.right != null) {
                        queue.offer(node.left);
                        queue.offer(node.right);
                    } else if (node.left != null) {
                        flag = false;
                        queue.offer(node.left);
                    } else if (node.right != null) {
                        return false;
                    } else {
                        flag = false;
                    }
                } else {
                    return node.left == null && node.right == null;
                }
            }
        }
        return true;
    }

}
