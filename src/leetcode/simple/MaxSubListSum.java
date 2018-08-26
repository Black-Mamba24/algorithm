package leetcode.simple;

/**
 * 动态规划准则：最优子结构、边界、状态转移方程
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * Created by zhaiyi on 2018/8/25.
 */
public class MaxSubListSum {
    public static void main(String[] args) {
        MaxSubListSum maxSubListSum = new MaxSubListSum();
        System.out.println(maxSubListSum.maxSubArray(new int[]{1,2,-1}));
    }

    public int maxSubArray(int[] nums) {
        int dp[] = new int[nums.length], max;
        max = dp[0] = nums[0];//边界
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);//状态转移方程
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
}
