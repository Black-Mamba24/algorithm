package leetcode.stack_queue;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class StackSequence946 {
    public static void main(String[] args) {
        StackSequence946 stackSequence946 = new StackSequence946();
        System.out.println(stackSequence946.validateStackSequences(new int[]{1}, new int[]{1}));
    }

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
}
