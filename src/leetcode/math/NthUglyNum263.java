package leetcode.math;

/**
 * 编写一个程序，找出第 n 个丑数。
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 * 示例:
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 核心：三个指针是+1移动，而不是跳着移动
 */
public class NthUglyNum263 {
    public static void main(String[] args) {
        NthUglyNum263 nthUglyNum263 = new NthUglyNum263();
        for (int i = 1; i < 10; i++) {
            System.out.println(nthUglyNum263.nthUglyNumber(6));
        }
    }

    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int num_2 = 0;
        int num_3 = 0;
        int num_5 = 0;
        for (int i = 1; i < n; i++) {
            ugly[i] = Math.min(Math.min(ugly[num_2] * 2, ugly[num_3] * 3), ugly[num_5] * 5);
            if (ugly[i] / ugly[num_2] == 2)
                num_2++;
            if (ugly[i] / ugly[num_3] == 3)
                num_3++;
            if (ugly[i] / ugly[num_5] == 5)
                num_5++;
        }
        return ugly[n - 1];
    }
}
