package leetcode.simple.num;

/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

 你可以假设数组是非空的，并且给定的数组总是存在众数。

 示例 1:

 输入: [3,2,3]
 输出: 3
 示例 2:

 输入: [2,2,1,1,1,2,2]
 输出: 2

 空间复杂度最低，抵消法
 * Created by zhaiyi on 2018/9/4.
 */
public class ZhongShu {
    public int majorityElement(int[] nums) {
        int counter = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (counter == 0) {
                result = nums[i];
                counter = 1;
            } else if (result == nums[i]) {
                counter ++;
            } else {
                counter --;
            }
        }
        return result;
    }
}
