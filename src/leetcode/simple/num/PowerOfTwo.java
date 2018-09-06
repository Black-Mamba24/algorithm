package leetcode.simple.num;

/**
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。

 示例 1:

 输入: 1
 输出: true
 解释: 20 = 1
 示例 2:

 输入: 16
 输出: true
 解释: 24 = 16
 * Created by zhaiyi on 2018/9/6.
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        int k = 1;
        //k > 0防止溢出
        while(k > 0 && k <= n) {
            if (k == n) {
                return true;
            } else {
                k *= 2;
            }
        }
        return false;
    }
}
