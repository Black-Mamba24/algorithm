package leetcode.subarray.hash;

import java.util.HashMap;
import java.util.Map;

/**
 *
 和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。

 现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。

 示例 1:

 输入: [1,3,2,2,5,2,3,7]
 输出: 5
 原因: 最长的和谐数组是：[3,2,2,2,3].
 说明: 输入的数组长度最大不超过20,000.

 思路：比较简单的hash表法，
 * Created by zhaiyi on 2018/9/18.
 */
public class Harmonious594 {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            int tmp = Math.max(map.getOrDefault(nums[i] - 1, 0), map.getOrDefault(nums[i] + 1, 0));
            if (tmp != 0) {
                max = Math.max(max, tmp + map.get(nums[i]));
            }
        }
        return max;
    }
}
