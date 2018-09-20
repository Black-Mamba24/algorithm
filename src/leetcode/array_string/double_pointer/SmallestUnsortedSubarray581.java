package leetcode.array_string.double_pointer;

/**
 *
 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。

 你找到的子数组应是最短的，请输出它的长度。

 示例 1:

 输入: [2, 6, 4, 8, 10, 9, 15]
 输出: 5
 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 说明 :

 输入的数组长度范围在 [1, 10,000]。
 输入的数组可能包含重复元素 ，所以升序的意思是<=。

 思路：从左到右计算最大值，从右到左计算最小值
 * Created by zhaiyi on 2018/9/18.
 */
public class SmallestUnsortedSubarray581 {
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int start = -1, end = -2, min = nums[nums.length - 1], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[nums.length - i -1]);
            if (nums[i] < max) {
                end = i;
            }
            if (nums[nums.length - i -1] > min) {
                start = nums.length - i -1;
            }
        }
        return end - start + 1;
    }
}
