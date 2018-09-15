package leetcode.array_string.trick;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

 示例 1:

 输入: [1,2,3,4,5,6,7] 和 k = 3
 输出: [5,6,7,1,2,3,4]
 解释:
 向右旋转 1 步: [7,1,2,3,4,5,6]
 向右旋转 2 步: [6,7,1,2,3,4,5]
 向右旋转 3 步: [5,6,7,1,2,3,4]

 思路：小技巧
 * Created by zhaiyi on 2018/9/4.
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        turn(nums, 0, nums.length - 1);
        turn(nums, 0, k - 1);
        turn(nums, k, nums.length - 1);
    }

    public void turn(int[] array, int start, int end) {
        while (start < end) {
            int tmp = array[start];
            array[start] = array[end];
            array[end] = tmp;
            start ++;
            end --;
        }
    }
}
