package leetcode.recursion;

/**
 * 整数划分问题。将一个整数n划分为最大值为m的划分，例如6，4的划分: 4+2, 3+1+1+1等
 *
 * 思路：递归思想，当n == 1或m == 1时只有一种结果
 * 当n == m时要么是最大值n，要么不包含n，最大值为n - 1
 * 当n < m时，不能出现负数，所以等同于n, n
 * 当n > m时，同样结果要么包含最大值m，即为n -m, m的划分，要么不包含最大值m即n, m-1的划分
 * 问题的关键就是找到判断条件，即是否包含最大值
 * Created by zhaiyi on 2018/10/14.
 */
public class NumDivide {
    public static void main(String[] args) {
        NumDivide numDivide = new NumDivide();
        System.out.println(numDivide.devide(6, 6));
    }

    /**
     * 将整数n划分为最大值为m的划分的个数
     *
     * @param n
     * @param m
     */
    public int devide(int n, int m) {
        if (n == 1 || m == 1) {
            return 1;
        } else if (n == m) {
            return 1 + devide(n, m - 1);
        } else if (n < m) {
            return devide(n, n);
        } else {
            return devide(n, m - 1) + devide(n - m, m);
        }
    }
}
