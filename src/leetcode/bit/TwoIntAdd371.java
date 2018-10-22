package leetcode.bit;

/**
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。

 示例 1:

 输入: a = 1, b = 2
 输出: 3

 思路：异或算非进位值，与操作+左移算进位，直到进位为0位置
 * Created by zhaiyi on 2018/10/19.
 */
public class TwoIntAdd371 {
    public int getSum(int a, int b) {
        //a为两数之和，b为进位
        while (b!=0) {
            int tmp = a ^ b;
            b = (a & b) << 1;
            a = tmp;
        }
        return a;
    }
}
