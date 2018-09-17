package leetcode.subarray.dp;

/**
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。

 示例：

 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()

 sumRange(0, 2) -> 1
 sumRange(2, 5) -> -1
 sumRange(0, 5) -> -3
 说明:

 1. 你可以假设数组不可变。
 2. 会多次调用 sumRange 方法。

 如果用注释掉的方法，构造二维数组会超时，可以将问题转换为0 - j的和减去0 - i-1的和。

 * Created by zhaiyi on 2018/9/8.
 */
public class ArrayRangeSum303 {
    public static void main(String[] args) {
        ArrayRangeSum303 arrayRangeSum303 = new ArrayRangeSum303(new int [] {-2, 0, 3, -5, 2, -1});
    }

//    public int [][] dp;
//
//    public ArrayRangeSum303(int[] nums) {
//        dp = new int[nums.length][nums.length];
//        for (int x = 0; x < nums.length; x++) {
//            dp[x][x] = nums[x];
//        }
//        for (int i = 0; i < nums.length; i ++) {
//            for (int j = i + 1; j < nums.length; j ++) {
//                dp[i][j] = dp[i][j - 1] + nums[j];
//            }
//        }
//    }
//
//    public int sumRange(int i, int j) {
//        return dp[i][j];
//    }

    public int [] dp;

    public ArrayRangeSum303(int[] nums) {
        if (nums.length > 0) {
            dp = new int[nums.length];
            dp[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = dp[i - 1] + nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        return i == 0 ? dp[j] : dp[j] - dp[i - 1];
    }
}
