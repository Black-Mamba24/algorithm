package leetcode.tree.queue;

import leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * Created by zhaiyi on 2018/8/28.
 */
public class LevelTraverseFromBottom {
    LinkedList<List<Integer>> result = new LinkedList<>();
    //capacity要看测试用例大小
    Queue<TreeNode> queue = new ArrayBlockingQueue(1000);

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return result;
        }
        queue.offer(root);
        levelTraverse();
        return result;
    }

    public void levelTraverse() {
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            //实现从底向上，插入到链表头部，如果是addLast()则为从顶向下
            result.addFirst(list);
        }
    }
}
