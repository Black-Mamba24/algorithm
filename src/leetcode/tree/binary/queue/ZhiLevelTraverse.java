package leetcode.tree.binary.queue;

import leetcode.tree.binary.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaiyi on 2018/9/28.
 */
public class ZhiLevelTraverse {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        boolean flag = true; //ture向左，false向右
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = null;
                if (flag) {
                    node = queue.pollFirst();
                    if (node.left != null) {
                        queue.offerLast(node.left);
                    }
                    if (node.right != null) {
                        queue.offerLast(node.right);
                    }
                } else {
                    node = queue.pollLast();
                    if (node.right != null) {
                        queue.offerFirst(node.right);
                    }
                    if (node.left != null) {
                        queue.offerFirst(node.left);
                    }
                }
                list.add(node.val);
            }
            res.add(list);
            flag = !flag;
        }
        return res;
    }
}
