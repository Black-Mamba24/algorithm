package leetcode.tree.dfs;

import java.util.ArrayDeque;
import java.util.Queue;
import leetcode.tree.TreeNode;

/**
 * 找树左下角的值
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 * Created by zhaiyi on 2018/12/3.
 */
public class LeftBottom513 {

    /**
     * 方法一：广度遍历，由于使用了队列，不是原地算法，虽然深度和广度算法都需要遍历所有节点，但广度开销还是大
     *
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    res = node.val;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }

    /**
     * 方法二：深度遍历，递归时记录上一次的结果和当前深度
     * @param root
     * @return
     */
    public int findBottomLeftValue2(TreeNode root) {
        int[] res = new int[2];
        dfs(root, 1, res);
        return res[1];
    }

    public void dfs(TreeNode node, int deep, int[] res) {
        if (node != null && node.left == null && node.right == null) {
            if (res[0] < deep) {
                res[0] = deep;
                res[1] = node.val;
            }
        } else if (node != null) {
            dfs(node.left, deep + 1, res);
            dfs(node.right, deep + 1, res);
        }
    }
}
