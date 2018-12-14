package leetcode.stack_queue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Temperture739 {
    public static void main(String[] args) {
        Temperture739 temperture739 = new Temperture739();
        temperture739.dailyTemperatures(new int[]{73, 69, 72, 76, 73, 67, 54, 78, 45, 45, 67, 65, 74, 75, 71});
    }

    /**
     * 用两个stack分别存值和下标，不是最优解
     *
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T) {
        //温度 -> 下标
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> index_stack = new Stack<>();
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > stack.peek()) {
                map.put(stack.pop() * 1000000 + index_stack.pop(), i);
            }
            stack.push(T[i]);
            index_stack.push(i);
        }
        for (int i = 0; i < T.length; i++) {
            int index = map.getOrDefault(T[i] * 1000000 + i, 0);
            res[i] = index == 0 ? 0 : index - i;
        }
        return res;
    }

    /**
     * 只用一个栈保存下标，一举双的，
     * @param T
     * @return
     */
    public int[] dailyTemperatures2(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }
        return res;
    }
}
