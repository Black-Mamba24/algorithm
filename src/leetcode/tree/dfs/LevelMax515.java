package leetcode.tree.dfs;

import leetcode.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * 在每个树行中找最大值
 * 您需要在二叉树的每一行中找到最大的值。
 *
 * 思路：用广度遍历可以实现，但用到线性数据结构，非原地算法。
 * 用深度遍历实现，速度更优，记录每个行当前最大值，后面再对比。
 */
public class LevelMax515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        find(root, res, 0);
        return res;
    }

    public void find(TreeNode node, List<Integer> res, int deep) {
        if (node != null) {
            if (res.size() <= deep) {
                res.add(node.val);
            } else {
                res.set(deep, Math.max(res.get(deep), node.val));
            }
            find(node.left, res, deep + 1);
            find(node.right, res, deep + 1);
        }
    }
}
