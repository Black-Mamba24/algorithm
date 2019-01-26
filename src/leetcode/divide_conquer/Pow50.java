package leetcode.divide_conquer;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 示例 1:

 输入: 2.00000, 10
 输出: 1024.00000
 示例 2:

 输入: 2.10000, 3
 输出: 9.26100
 示例 3:

 输入: 2.00000, -2
 输出: 0.25000
 解释: 2-2 = 1/22 = 1/4 = 0.25
 * Created by zhaiyi on 2019/1/23.
 */
public class Pow50 {
    public double myPow(double x, int n) {
        if (x == 0 || x == 1) {
            return x;
        }
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        } else if (n == -1) {
            return 1 / x;
        } else {
            if (n % 2 == 0) {
                double r = myPow(x, n / 2);
                return r * r;
            } else {
                double r = myPow(x, n / 2);
                if (n > 0) {
                    return x * r * r;
                } else {
                    return 1 / x * r * r;
                }
            }
        }
    }

    public static void main(String[] args) {
        Pow50 pow50 = new Pow50();
        System.out.println(pow50.myPow(2.0, -3));
    }
}
