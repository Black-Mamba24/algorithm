package leetcode.tree.queue;

import leetcode.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 完全二叉树是每一层（除最后一层外）都是完全填充（即，结点数达到最大）的，并且所有的结点都尽可能地集中在左侧。

 设计一个用完全二叉树初始化的数据结构 CBTInserter，它支持以下几种操作：

 CBTInserter(TreeNode root) 使用头结点为 root 的给定树初始化该数据结构；
 CBTInserter.insert(int v) 将 TreeNode 插入到存在值为 node.val = v  的树中以使其保持完全二叉树的状态，并返回插入的 TreeNode 的父结点的值；
 CBTInserter.get_root() 将返回树的头结点。


 示例 1：

 输入：inputs = ["CBTInserter","insert","get_root"], inputs = [[[1]],[2],[]]
 输出：[null,1,[1,2]]
 示例 2：

 输入：inputs = ["CBTInserter","insert","insert","get_root"], inputs = [[[1,2,3,4,5,6]],[7],[8],[]]
 输出：[null,3,4,[1,2,3,4,5,6,7,8]]

 * Created by zhaiyi on 2018/10/7.
 */
public class CBTInserter919 {
    public TreeNode root;
    public int i = 0;
    public Queue<TreeNode> queue = new ArrayDeque<>();

    public CBTInserter919(TreeNode root) {
        this.root = root;
        Queue<TreeNode> queue_ = new ArrayDeque<>();
        queue_.offer(root);
        boolean flag = true;
        while (!queue_.isEmpty()) {
            int size = queue_.size();
            for (int j = 0; j < size; j++) {
                TreeNode node = queue_.poll();
                if (node.left != null) {
                    queue_.offer(node.left);
                }
                if (node.right != null) {
                    queue_.offer(node.right);
                }
                if (node.left == null || node.right == null) {
                    queue.offer(node);
                    if (flag) {
                        flag = false;
                        if (node.left == null) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                    }
                }
            }
        }
        queue_.clear();
    }

    public int insert(int v) {
        TreeNode node = queue.peek();
        TreeNode newN = new TreeNode(v);
        if (i == 0) {
            node.left = newN;
        } else {
            node.right = newN;
            queue.poll();
        }
        i = (i + 1) % 2;
        queue.offer(newN);
        return node.val;
    }

    public TreeNode get_root() {
        return root;
    }
}
