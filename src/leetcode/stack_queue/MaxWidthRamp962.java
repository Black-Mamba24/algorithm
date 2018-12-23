package leetcode.stack_queue;

import java.util.Map;
import java.util.Stack;

/**
 * 最大宽度坡
 * 给定一个整数数组 A，坡是元组 (i, j)，其中  i < j 且 A[i] <= A[j]。这样的坡的宽度为 j - i。
 * 找出 A 中的坡的最大宽度，如果不存在，返回 0 。
 * Created by zhaiyi on 2018/12/23.
 */
public class MaxWidthRamp962 {
    public int maxWidthRamp(int[] A) {
        Stack<Pair> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            if (stack.isEmpty() || A[i] < stack.peek().value) {
                stack.push(new Pair(A[i], i));
            }
        }

        for (int i = A.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[i] >= stack.peek().value) {
                Pair pair = stack.pop();
                max = Math.max(max, i - pair.index);
            }
        }
        return max;
    }
}

class Pair {
    int value;
    int index;

    Pair(int value, int index) {
        this.value = value;
        this.index = index;
    }
}
