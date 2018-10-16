package leetcode.besection.array;

/**
 *
 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。

 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。

 说明:

 返回的下标值（index1 和 index2）不是从零开始的。
 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 示例:

 输入: numbers = [2, 7, 11, 15], target = 9
 输出: [1,2]
 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。

 思路：因为双数之和的解法，此题也可以用hash表实现。但这样没利用数组有序的特性。有序第一反应是二分查找，
 * Created by zhaiyi on 2018/10/16.
 */
public class TwoNumsSum167 {
    public int[] twoSum(int[] numbers, int target) {
        int [] res = new int[2];
        // Map<Integer, Integer> map = new HashMap();
        // for (int i = 0; i < numbers.length; i++) {
        //     if (map.containsKey(target - numbers[i])) {
        //         result[0] = map.get(target - numbers[i]) + 1;
        //         result[1] = i + 1;
        //         return result;
        //     } else {
        //         map.put(numbers[i], i);
        //     }
        // }
        // return null;

        int start = 0, end = numbers.length - 1;
        while (start < end) {
            int tmp = numbers[start] + numbers[end];
            if (tmp > target) {
                end -= 1;
            } else if (tmp < target) {
                start += 1;
            } else {
                res[0] = start + 1;
                res[1] = end + 1;
                return res;
            }
        }
        return null;
    }
}
