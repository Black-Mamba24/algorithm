package leetcode.subarray.dp;

/**
 * 给定一个由整数数组 A 表示的环形数组 C，求 C 的非空子数组的最大可能和。

 在此处，环形数组意味着数组的末端将会与开头相连呈环状。（形式上，当0 <= i < A.length 时 C[i] = A[i]，而当 i >= 0 时 C[i+A.length] = C[i]）

 此外，子数组最多只能包含固定缓冲区 A 中的每个元素一次。（形式上，对于子数组 C[i], C[i+1], ..., C[j]，不存在 i <= k1, k2 <= j 其中 k1 % A.length = k2 % A.length）

 思路：计算子数组最大和、最小和，可通过动态规划思想去做，环形子数组最大值应为普通子数组最大和，与 总和-普通子数组最小和的最大值
 需要注意的是total - min一定是>= 0的，另外只要有一个数字大于0，那么结果一定大于0（至少是这个正数），因此当max < 0时，所有都是负数，应去最大的负数
 * Created by zhaiyi on 2018/10/9.
 */
public class CycleArrayMaxSubArraySum919 {
    public static void main(String[] args) {
        CycleArrayMaxSubArraySum919 cycleArrayMaxSubArraySum919 = new CycleArrayMaxSubArraySum919();
        System.out.println(cycleArrayMaxSubArraySum919.maxSubarraySumCircular(new int[]{-3,2, -1, 6,-7, -1, -1}));
    }

    public int maxSubarraySumCircular(int[] A) {
        int total = 0, max, sum_max;
        int min, sum_min;

        max = sum_max = min = sum_min = total = A[0];
        for (int i = 1; i < A.length; i++) {
            total += A[i];

            if (sum_max > max) {
               max = sum_max;
            } else if (sum_max < 0) {
                sum_max = 0;
            }
            sum_max += A[i];
            max = Math.max(max, sum_max);

            if (sum_min < min) {
                min = sum_min;
            } else if (sum_min > 0) {
                sum_min = 0;
            }
            sum_min += A[i];
            min = Math.min(min, sum_min);
        }

        if (max < 0) {
            return max;
        }
        return Math.max(max, total - min);
    }
}
