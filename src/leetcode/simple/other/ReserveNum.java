package leetcode.simple.other;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Scanner;

/**
 * 给定一个 32 位有符号整数，将整数中的数字进行反转，如果溢出则输出0。
 * Created by zhaiyi on 2018/8/24.
 */
public class ReserveNum {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt(), result = 0;
        while (num != 0) {
            int a = num % 10;
            num /= 10;
            if (result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && a > 7) {
                System.out.println(0);
                return;
            } else if (result < Integer.MIN_VALUE / 10 || result == Integer.MIN_VALUE / 10 && a < -8) {
                System.out.println(0);
                return;
            } else {
                result = result * 10 + a;
            }
        }
        System.out.println(result);
    }
}
