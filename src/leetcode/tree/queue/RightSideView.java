package leetcode.tree.queue;

import leetcode.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

 示例:

 输入: [1,2,3,null,5,null,4]
 输出: [1, 3, 4]
 解释:

     1            <---
   /   \
  2     3         <---
   \     \
    5     4       <---
 思路：使用队列，层次遍历，将每个层次最后一个元素加入结果列表
 * Created by zhaiyi on 2018/9/27.
 */
public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == size - 1) {
                    list.add(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return list;
    }
}
