package leetcode.tree;
import java.util.*;

/**
 * 二叉树中所有距离为 K 的结点
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 * 看答案的。。思路很棒
 */
public class DistanceK863 {
    public Map<TreeNode, TreeNode> map = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        findParent(root);
        dfs(target, K, new HashSet<>(), res);
        return res;
    }

    /**
     * 先找父节点
     * @param node
     */
    public void findParent(TreeNode node) {
        if (node != null) {
            if (node.left != null) {
                map.put(node.left, node);
            }
            if (node.right != null) {
                map.put(node.right, node);
            }
            findParent(node.left);
            findParent(node.right);
        }
    }

    /**
     * 三相dfs（left、right、parent）
     * @param node
     * @param K
     * @param visited
     * @param list
     */
    public void dfs(TreeNode node, int K, Set<TreeNode> visited, List<Integer> list) {
        if (node != null && !visited.contains(node)) {
            visited.add(node);
            if (K == 0) {
                list.add(node.val);
            } else {
                dfs(node.left, K - 1, visited, list);
                dfs(node.right, K - 1, visited, list);
                dfs(map.get(node), K - 1, visited, list);
            }
        }
    }
}
