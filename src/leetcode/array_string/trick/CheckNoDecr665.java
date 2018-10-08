package leetcode.array_string.trick;

/**
 * 定一个长度为 n 的整数数组，你的任务是判断在最多改变 1 个元素的情况下，该数组能否变成一个非递减数列。

 我们是这样定义一个非递减数列的： 对于数组中所有的 i (1 <= i < n)，满足 array[i] <= array[i + 1]。

 示例 1:

 输入: [4,2,3]
 输出: True
 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 示例 2:

 输入: [4,2,1]
 输出: False
 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。

 思路：开始分析时发现有很多情况，但只要分析i + 1 和 i - 1大小。如果i + 1 >= i - 1说明趋势递增，只有i是突刺，否则变换i + 1为低谷。
 * Created by zhaiyi on 2018/10/8.
 */
public class CheckNoDecr665 {
    public boolean checkPossibility(int[] nums) {
        if (nums.length <= 2) {
            return true;
        }
        // int count = 0;
        // for (int i = 0; i < nums.length - 1; i++) {
        //     if (nums[i] > nums[i+1]) {
        //         count++;
        //         if (count > 1) {
        //             return false;
        //         } else {
        //             if (i - 1 >= 0) {
        //                 if (nums[i + 1] > nums[i - 1]) {
        //                     nums[i] = nums[i+1];
        //                 } else if (nums[i + 1] < nums[i - 1]) {
        //                     nums[i + 1] = nums[i];
        //                 }
        //             } else {
        //                 nums[i] = nums[i + 1];
        //             }
        //         }
        //     }
        // }
        // return true;

        boolean flag = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (flag) {
                    return false;
                } else {
                    flag = true;
                    if (i > 0) {
                        if (nums[i + 1] < nums[i - 1]) {
                            nums[i+ 1] = nums[i];
                        }
                    }
                }
            }
        }
        return true;
    }
}
