package leetcode.tree.resursion;

import leetcode.tree.TreeNode;

/**
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：

 二叉树的根是数组中的最大元素。
 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 通过给定的数组构建最大二叉树，并且输出这个树的根节点。

 Example 1:

 输入: [3,2,1,6,0,5]
 输入: 返回下面这棵树的根节点：

      6
    /   \
   3     5
   \    /
    2  0
     \
      1
 * Created by zhaiyi on 2018/10/29.
 */
public class MaxTree654 {
    public static void main(String[] args) {
        MaxTree654 maxTree654 = new MaxTree654();
        TreeNode node = maxTree654.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
        System.out.println();
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int[] nums, int start, int end) {
        if (start < end) {
            int max = nums[start];
            int max_index = start;
            for (int i = start + 1; i <= end; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                    max_index = i;
                }
            }
            TreeNode root = new TreeNode(max);
            root.left = build(nums, start, max_index - 1);
            root.right = build(nums, max_index + 1, end);
            return root;
        } else if (start == end) {
            return new TreeNode(start);
        } else {
            return null;
        }
    }
}
