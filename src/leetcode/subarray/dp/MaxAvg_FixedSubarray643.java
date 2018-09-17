package leetcode.subarray.dp;

/**
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。

 示例 1:

 输入: [1,12,-5,-6,50,3], k = 4
 输出: 12.75
 解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75


 注意:

 1 <= k <= n <= 30,000。
 所给数据范围 [-10,000，10,000]。

 思路：简单动态规划，用差值计算子数组和
 * Created by zhaiyi on 2018/9/17.
 */
public class MaxAvg_FixedSubarray643 {
    public double findMaxAverage(int[] nums, int k) {
        long [] dp = new long[nums.length];
        long max = Long.MIN_VALUE;
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] + nums[i];
            if (i <= k - 1) {
                max = dp[i];
            } else if (i >= k) {
                max = Math.max(max, dp[i] - dp[i - k]);
            }
        }
        return nums.length <= k ? dp[nums.length - 1] * 1.0 / k : max * 1.0 / k;
    }
}
