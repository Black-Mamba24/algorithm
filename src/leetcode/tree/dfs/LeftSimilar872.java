package leetcode.tree.dfs;

import java.util.ArrayList;
import leetcode.tree.TreeNode;

/**
 * 叶子相似的树
 * 请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列。
 * 如果有两颗二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 * 如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false。
 * 思路：典型深度遍历，简单题
 * Created by zhaiyi on 2018/12/3.
 */
public class LeftSimilar872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        getLefts(root1, list1);
        getLefts(root2, list2);
        return list1.equals(list2);
    }

    public void getLefts(TreeNode node, ArrayList<Integer> list) {
        if (node != null && node.left == null && node.right == null) {
            list.add(node.val);
        } else if (node != null) {
            getLefts(node.left, list);
            getLefts(node.right, list);
        }
    }

}
