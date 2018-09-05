package leetcode.simple.num;

/**
 * 统计所有小于非负整数 n 的质数的数量。

 示例:

 输入: 10
 输出: 4
 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * Created by zhaiyi on 2018/9/5.
 */
public class PrimeCount {
    public int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }
        //技巧一：利用boolean初始化都为false，2、3初始就是false，无需初始化
        //技巧二：遇到false都是质数，无法证明这个结论，但这个结论是正确的
        boolean [] isNotPrimes = new boolean[n+1];
        for (int i = 2; i < n; i++) {
            if (!isNotPrimes[i]) {
                for (int j = i * 2; j <= n; j += i) {
                    isNotPrimes[j] = true;
                }
            }
        }
        int result = 0;
        for(int i = 2; i < n; i++) {
            if (!isNotPrimes[i]) {
                result++;
            }
        }
        return result;
    }
}
