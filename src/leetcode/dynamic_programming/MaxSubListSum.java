package leetcode.dynamic_programming;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

 示例:

 输入: [-2,1,-3,4,-1,2,1,-5,4],
 输出: 6
 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

 * 动态规划准则：最优子结构、边界、状态转移方程
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
            //下面的更好理解，只要前面的和>0就需要累加，否则重启一段
//            if (dp[i - 1] < 0) {
//                dp[i] = nums[i];
//            } else {
//                dp[i] = dp[i - 1] + nums[i];
//            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
}
