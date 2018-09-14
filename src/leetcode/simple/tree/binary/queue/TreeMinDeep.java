package leetcode.simple.tree.binary.queue;

import leetcode.simple.tree.binary.TreeNode;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 给定一个二叉树，找出其最小深度。

 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

 说明: 叶子节点是指没有子节点的节点。

 示例:

 给定二叉树 [3,9,20,null,null,15,7],

     3
    / \
   9  20
  /  \
 15   7
 返回它的最小深度  2.

 * Created by zhaiyi on 2018/8/29.
 */
public class TreeMinDeep {
    /* 方法一：层次遍历，找出第一个左右儿子都为空的节点，返回层高 */
    public Queue<TreeNode> queue = new ArrayBlockingQueue<>(1000);

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        queue.offer(root);
        return levelTraverse();
    }

    public int levelTraverse() {
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left == null && node.right == null) {
                    return level;
                }
            }
        }
        return level;
    }

    /* 方法二：递归，找计算所有叶子节点最小高度 */
    int min = Integer.MAX_VALUE;

    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        deepTraverse(root, 1);
        return min;
    }

    public void deepTraverse(TreeNode node, int deep) {
        if(node != null) {
            if(node.left == null && node.right == null) {
                min = Math.min(min, deep);
            } else {
                deepTraverse(node.left, deep + 1);
                deepTraverse(node.right, deep + 1);
            }
        }
    }
}
