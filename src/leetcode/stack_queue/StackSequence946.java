package leetcode.stack_queue;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class StackSequence946 {
    public static void main(String[] args) {
        StackSequence946 stackSequence946 = new StackSequence946();
        System.out.println(stackSequence946.validateStackSequences(new int[]{1}, new int[]{1}));
    }

    /**
     * 竞赛时想到的方法，能通过，但不是最佳，使用了额外的空间，可以用原地算法
     *
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();
        int push_index = 0, pop_index = 0;

        while (push_index < pushed.length || pop_index < popped.length) {
            if (set.contains(popped[pop_index])) {
                if (stack.peek() == popped[pop_index]) {
                    stack.pop();
                    set.remove(popped[pop_index]);
                    pop_index++;
                } else {
                    return false;
                }
            } else {
                stack.push(pushed[push_index]);
                set.add(pushed[push_index]);
                push_index++;
            }
        }
        return true;
    }

    /**
     * 最优解，原地算法
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0, j = 0; i < pushed.length; i++) {
            if (pushed[i] == popped[j]) {
                j++;
                while (j < popped.length && !stack.isEmpty() && stack.peek() == popped[j]) {
                    j++;
                    stack.pop();
                }
            } else {
                stack.push(pushed[i]);
            }
        }
        return !stack.isEmpty();
    }
}
