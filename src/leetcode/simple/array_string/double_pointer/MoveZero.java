package leetcode.simple.array_string.double_pointer;

/**
 *
 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

 示例:

 输入: [0,1,0,3,12]
 输出: [1,3,12,0,0]
 说明:

 必须在原数组上操作，不能拷贝额外的数组。
 尽量减少操作次数。

 思路：有头尾操作联想双指针法，头部正向找0，尾部逆向找非0，平移头尾之间的数组，将0移到尾部
 * Created by zhaiyi on 2018/9/10.
 */
public class MoveZero {
    public void moveZeroes(int[] nums) {
        int head = 0, tail = nums.length - 1;
        while (head < tail) {
            while (head < nums.length && nums[head] != 0) {
                head++;
            }
            while (tail >= 0 && nums[tail] == 0) {
                tail --;
            }
            for (int i = head + 1; i <= tail; i++) {
                nums[i - 1] = nums[i];
            }
            if (head < tail) {
                nums[tail] = 0;
            }
        }
    }
}
