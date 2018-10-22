package leetcode.tree.bst;

import leetcode.tree.TreeNode;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。

 假设一个二叉搜索树具有如下特征：

 节点的左子树只包含小于当前节点的数。
 节点的右子树只包含大于当前节点的数。
 所有左子树和右子树自身必须也是二叉搜索树。
 示例 1:

 输入:
   2
  / \
 1   3
 输出: true

 思路：BST的中序遍历是有序的，可以利用这个特性，再判断list是否为递增。
 这种方法并不是最优解。递归时增加两个参数，(left, right)为当前节点有效区间。另一个技巧是expressA && expressB 只要任何一个表达式为false，都会终止递归，不会遍历所有节点
 * Created by zhaiyi on 2018/10/2.
 */
public class JudgeBST98 {
    //     public boolean isValidBST(TreeNode root) {
//         List<Integer> list = new ArrayList<>();
//         traverse(root, list);
//         for (int i = 0; i < list.size() - 1; i++) {
//             if (list.get(i) >= list.get(i + 1)) {
//                 return false;
//             }
//         }
//         return true;
//     }

//     public void traverse(TreeNode node, List<Integer> list) {
//         if (node != null) {
//             traverse(node.left, list);
//             list.add(node.val);
//             traverse(node.right, list);
//         }
//     }

    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean dfs(TreeNode node, long left, long right) {
        if (node != null) {
            int val = node.val;
            if (val >= right || val <= left) {
                return false;
            } else {
                return dfs(node.left, left, val) && dfs(node.right, val, right);
            }
        }
        return true;
    }
}
