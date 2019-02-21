package leetcode.dp;

import java.util.Arrays;

/**
 * 给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
 */
public class CombinationSum377 {
    public static void main(String[] args) {
        CombinationSum377 combinationSum377 = new CombinationSum377();
        System.out.println(combinationSum377.combinationSum4(new int[] {3, 33, 333}, 10000));
    }

    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int n : nums) {
                if (i - n >= 0) {
                    dp[i] += dp[i - n];
                } else {
                    break;
                }
            }
        }
        return dp[target];
    }

}
