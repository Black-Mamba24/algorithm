package leetcode.simple.other;

/**
 *
 实现 int sqrt(int x) 函数。

 计算并返回 x 的平方根，其中 x 是非负整数。

 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * Created by zhaiyi on 2018/8/27.
 */
public class Sqrt {
    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();
        System.out.println(sqrt.mySqrt(9));
    }

    public int mySqrt(int x) {
        if (x == 0) {
            return x;
        }
        double last = x;
        while (true) {
            double now = (last + x / last) / 2;
            if (Math.abs(now - last) < 0.001) return (int) now;
            last = now;
        }
    }
}
