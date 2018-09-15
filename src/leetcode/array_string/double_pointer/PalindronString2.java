package leetcode.array_string.double_pointer;

/**
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。

 示例 1:

 输入: "aba"
 输出: True
 示例 2:

 输入: "abca"
 输出: True
 解释: 你可以删除c字符。

 思路：明显的双指针法，但需要注意的是当出现左右不同时不一定移动左或右，所以要用||操作
 * Created by zhaiyi on 2018/9/11.
 */
public class PalindronString2 {
    public static void main(String[] args) {
        PalindronString2 palindronString2 = new PalindronString2();
        System.out.println(palindronString2.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }

    public boolean validPalindrome(String s) {
        if (s == null || s.equals("")) {
            return true;
        }
        return valid(s, 0, s.length() - 1);
    }

    public boolean deleted = false;

    public boolean valid(String s, int l, int r) {
        if (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                return valid(s, l + 1, r - 1);
            } else {
                if (deleted) {
                    return false;
                } else {
                    deleted = true;
                    return valid(s, l + 1, r) || valid(s, l, r - 1);
                }
            }
        }
        return true;
    }
}
