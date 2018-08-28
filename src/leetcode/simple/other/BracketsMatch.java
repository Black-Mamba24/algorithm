package leetcode.simple.other;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

 有效字符串需满足：

 左括号必须用相同类型的右括号闭合。
 左括号必须以正确的顺序闭合。
 注意空字符串可被认为是有效字符串。
 * Created by zhaiyi on 2018/8/24.
 */
public class BracketsMatch {
    public static void main(String[] args) {
        BracketsMatch bracketsMatch = new BracketsMatch();
        System.out.println(bracketsMatch.isValid("{()}"));
    }
    Stack<String> stack = new Stack<>();
    public boolean isValid(String s) {
        if (s == null || s.equals("")) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            String tmp = s.charAt(i) + "";
            switch(tmp) {
                case "(":
                case "[":
                case "{":
                    stack.push(tmp);
                    break;
                case ")":
                    if (stack.isEmpty() || !stack.peek().equals("(")) {
                        return false;
                    }
                    stack.pop();
                    break;
                case "]":
                    if (stack.isEmpty() || !stack.peek().equals("[")) {
                        return false;
                    }
                    stack.pop();
                    break;
                case "}":
                    if (stack.isEmpty() || !stack.peek().equals("{")) {
                        return false;
                    }
                    stack.pop();
                    break;
                default:
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
