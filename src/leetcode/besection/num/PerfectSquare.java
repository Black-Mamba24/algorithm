package leetcode.besection.num;

/**
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。

 说明：不要使用任何内置的库函数，如  sqrt。

 示例 1：

 输入：16
 输出：True
 思路：明显的二分法，但要注意int相加，相乘都可能溢出
 * Created by zhaiyi on 2018/9/14.
 */
public class PerfectSquare {
    public static void main(String[] args) {
        PerfectSquare perfectSquare = new PerfectSquare();
        System.out.println(perfectSquare.isPerfectSquare(Integer.MAX_VALUE));
    }
    public boolean isPerfectSquare(int num) {
        long l = 1, r = num;
        while(l <= r) {
            long mid = (l + r) / 2;
            long mul = mid * mid;
            if (mul == num) {
                return true;
            } else if (mul > num) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }
}
