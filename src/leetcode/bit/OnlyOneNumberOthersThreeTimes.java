package leetcode.bit;

import java.util.*;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。

 说明：

 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

 示例 1:

 输入: [2,2,3,2]
 输出: 3

 思路：将数组中每个数字看成二进制表示，如果每个数字都出现3次，那所有数字第x位的和一定是3的倍数或0，如果不是就是因为那个特殊的数字
 对int 32位依次计算，每次掩码为第x位
 * Created by zhaiyi on 2018/8/31.
 */
public class OnlyOneNumberOthersThreeTimes {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int mask = 1<< i;
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((mask & nums[j]) != 0) {
                    count++;
                }
            }
            //累加特殊数字所有二进制位置上为1的值
            if (count % 3 != 0) {
                result |= mask;
            }
        }
        return result;
    }
}
