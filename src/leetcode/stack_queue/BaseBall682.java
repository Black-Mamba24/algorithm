package leetcode.stack_queue;

import java.util.Stack;

public class BaseBall682 {
    public int calPoints(String[] ops) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (String s :ops) {
            int grade;
            switch (s) {
                case "+":
                    int x = stack.pop();
                    grade = stack.peek() + x;
                    stack.push(x);
                    stack.push(grade);
                    res += grade;
                    break;
                case "D":
                    grade = stack.peek() * 2;
                    stack.push(grade);
                    res += grade;
                    break;
                case "C":
                    res -= stack.pop();
                    break;
                default:
                    grade = Integer.valueOf(s);
                    stack.push(grade);
                    res += grade;
            }
        }
        return res;
    }
}
