package leetcode.tree.bst;

import leetcode.tree.TreeNode;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

 示例:

 给定有序数组: [-10,-3,0,5,9],

 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

     0
    / \
  -3   9
  /   /
 -10  5

 当构建二叉树时递归需要带有返回值，每个次递归构建一个节点，层层返回。
 与前面遍历树返回值不同（boolean或void），构建树 -> 返回根节点
 * Created by zhaiyi on 2018/8/29.
 */
public class SortedArrayToBST {
    public static void main(String[] args) {
        SortedArrayToBST sortedArrayToBST = new SortedArrayToBST();
        TreeNode treeNode = sortedArrayToBST.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        sortedArrayToBST.middleTraverse(treeNode);
    }

    public void middleTraverse(TreeNode treeNode) {
        if (treeNode != null) {
            middleTraverse(treeNode.left);
            System.out.print(treeNode.val + " ");
            middleTraverse(treeNode.right);
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return buildBST(nums, 0, nums.length - 1);
    }

    public TreeNode buildBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, start, mid - 1);
        root.right = buildBST(nums, mid + 1, end);
        return root;
    }
}
