package leetcode.recursion.back_tracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 * <p>
 * 示例:
 * 输入: S = "a1b2"
 * 输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
 * <p>
 * 输入: S = "3z4"
 * 输出: ["3z4", "3Z4"]
 * <p>
 * 输入: S = "12345"
 * 输出: ["12345"]
 * 注意：
 * <p>
 * S 的长度不超过12。
 * S 仅由数字和字母组成。
 */
public class LetterCasePernutatuion784 {
    public static void main(String[] args) {
        LetterCasePernutatuion784 letterCasePernutatuion784 = new LetterCasePernutatuion784();
        System.out.println(letterCasePernutatuion784.letterCasePermutation("qqq"));
    }

    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        helper(res, S.toCharArray(), 0);
        return res;
    }

    public void helper(List<String> list, char[] chars, int index) {
        if (index == chars.length) {
            list.add(new String(chars));
        } else {
            char c = chars[index];
            if (c >= '0' && c <= '9') {
                helper(list, chars, index + 1);
            } else if (c >= 'a' && c <= 'z') {
                helper(list, chars, index + 1);
                chars[index] -= 32;
                helper(list, chars, index + 1);
            } else {
                helper(list, chars, index + 1);
                chars[index] += 32;
                helper(list, chars, index + 1);
            }
        }
    }

}
