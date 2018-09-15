package leetcode.num;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个算法来判断一个数是不是“快乐数”。

 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。

 示例:

 输入: 19
 输出: true
 解释:
 12 + 92 = 82
 82 + 22 = 68
 62 + 82 = 100
 12 + 02 + 02 = 1
 思路：把所有运算结果存起来，如果出现重复则返回false，定义最大重试次数，超过也返回false
 * Created by zhaiyi on 2018/9/5.
 */
public class HappyNum {
    public static void main(String[] args) {
        HappyNum happyNum = new HappyNum();
        happyNum.isHappy(12);
    }
    Set<Integer> set = new HashSet<>();
    public boolean isHappy(int n) {
        for (int i = 0; i < 1000; i++) {
            int tmp = n;
            int result = 0;
            while (tmp > 0) {
                int last = tmp % 10;
                tmp /= 10;
                result += (last * last);
            }
            if (result == 1) {
                return true;
            }
            n = result;
            if (set.contains(result)) {
                return false;
            } else {
                set.add(result);
            }
        }
        return false;
    }
}
