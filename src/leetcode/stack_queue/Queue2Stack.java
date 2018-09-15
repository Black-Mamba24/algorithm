package leetcode.stack_queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by zhaiyi on 2018/9/7.
 */
public class Queue2Stack {
    Deque<Integer> deque;

    /** Initialize your data structure here. */
    public Queue2Stack() {
        deque = new ArrayDeque<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        deque.offerLast(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return deque.pollLast();
    }

    /** Get the top element. */
    public int top() {
        return deque.peekLast();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return deque.isEmpty();
    }
}
