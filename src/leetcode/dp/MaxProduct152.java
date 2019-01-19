package leetcode.dp;

/**
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。 示例 1: 输入: [2,3,-2,4] 输出: 6 解释: 子数组 [2,3] 有最大乘积 6。
 */
public class MaxProduct152 {
    public static void main(String[] args) {
        MaxProduct152 maxProduct152 = new MaxProduct152();
        maxProduct152.maxProduct(new int[] {3, -1, 4});
    }

    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int max1 = 0, max2 = 0;
        int cur1 = 1, cur2 = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                cur1 = 1;
            } else {
                cur1 *= nums[i];
                max1 = Math.max(max1, cur1);
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                cur2 = 1;
            } else {
                cur2 *= nums[i];
                max2 = Math.max(max2, cur2);
            }
        }
        return Math.max(max1, max2);
    }
}
