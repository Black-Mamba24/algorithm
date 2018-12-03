package leetcode.recursion.back_tracking;

import java.util.*;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class GenerateParenthesis22 {
    public List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        GenerateParenthesis22 generateParenthesis22 = new GenerateParenthesis22();
        System.out.println(generateParenthesis22.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        gen("", n, n);
        return list;
    }

    /**
     *
     * @param string
     * @param l 左括号剩余个数
     * @param r 右括号剩余个数
     */
    public void gen(String string, int l, int r) {
        if (l == 0 && r == 0) {
             list.add(string);
        } else {
            //尽可能使用"("
            if (l > 0) {
                gen(string + "(", l - 1, r);
            }
            if (l < r) {
                gen(string + ")", l, r - 1);
            }
        }
    }
}
