package leetcode.simple.array_string;

import java.util.Scanner;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。负数不是回文
 * 只计算一半
 * Created by zhaiyi on 2018/8/24.
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int res = 0;
        while (num > res) {
            int tmp = num % 10;
            num /= 10;
            res = res * 10 + tmp;
        }
        System.out.println(res == num || res / 10 == num);
    }
}
