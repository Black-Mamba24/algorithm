package leetcode.recursion;

import java.util.Stack;

/**
 * 汉诺塔问题
 * Created by zhaiyi on 2018/10/12.
 */
public class Hanoi {
    public static void main(String[] args) {
        Stack<Integer> a = new Stack<>();
        Stack<Integer> b = new Stack<>();
        Stack<Integer> c = new Stack<>();
        int count = 5;
        for (int i = count; i >= 1; i--) {
            a.push(i);
        }
        hanoi(count, a, b, c);
        while (!c.isEmpty()) {
            System.out.println(c.pop());
        }
     }

    /**
     * 将n个盘子从a借助b移动到c
     * @param n
     * @param a
     * @param b
     * @param c
     */
     public static void hanoi(int n, Stack<Integer> a, Stack<Integer> b, Stack<Integer> c) {
        if (n > 0) {
            hanoi (n - 1, a, c, b);
            c.push(a.pop());
            hanoi(n - 1, b, a, c);
        }
     }

}
