package leetcode.simple.num;

/**
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。

 示例:

 输入: 38
 输出: 2
 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 要求在O(1)时间复杂度内完成

 思路：
 假设一个四位数num = ABCD；即num=A*1000+B*100+C*10+D;

 num=A+B+C+D+(A*999+B*99+C*9)

 这样左边的数就是各位数的和，而右边的数一直都能被9整除；如果A+B+C+D大于9了，则可以再次套用上面的公式，所以对9取余即可。

 * Created by zhaiyi on 2018/9/8.
 */
public class DigitsAdd {
    public int addDigits(int num) {
        if (num == 0) {
            return 0;
        }

        int res = num % 9;
        return res == 0 ? 9 : res;
    }
}
