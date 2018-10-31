package leetcode.bit;

import java.util.Stack;

/**
 * 给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。

 注意:

 给定的整数保证在32位带符号整数的范围内。
 你可以假定二进制数不包含前导零位。
 示例 1:

 输入: 5
 输出: 2
 解释: 5的二进制表示为101（没有前导零位），其补数为010。所以你需要输出2。

 思路：注意>>是带符号右移，>>>是无符号右移。整体左移出来，去掉前导0，再异或，再增加前导0.
 * Created by zhaiyi on 2018/10/23.
 */
public class QuFan476 {
    public static void main(String[] args) {
        System.out.println(findComplement(5));
    }

    public static int findComplement(int num) {
        int k = 1 << 31;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((num & k) == 0) {
                count ++;
                num <<= 1;
            } else {
                break;
            }
        }

        for (int i = 0; i < 32 -count; i++) {
            print(num);
            num ^= k;
            k >>>= 1;
        }
        print(num);
        for (int i = 0; i < count; i++) {
            num >>= 1;
        }
        return num;
    }

    public static void print(int num) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 32; i++) {
            int tmp = num & 1;
            stack.push(tmp);
            num >>= 1;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
        System.out.println();
    }
}
