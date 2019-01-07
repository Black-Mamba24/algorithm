package leetcode.dp;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba"也是一个有效答案。
 * Created by zhaiyi on 2018/10/31.
 */
public class LongestPalidrano5 {
    public static void main(String[] args) {
        LongestPalidrano5 longestPalidrano5 = new LongestPalidrano5();
        System.out.println(longestPalidrano5.longestPalindrome2("ozienididididvabcbaixoaovjiuahcsj"));
    }

    /**
     * 方法一：动态规划算法
     * 用一个二维数组记录从i ~ j子数组是否为回文。当判断x ~ y是否是回文时只需判断x+1 ~ y-1是否是回文 & xy是否相等。但动态规划创建二维数组是不得已才这么做的，创建、更新数组过于耗时。
     * 时间复杂度O(n ^ 2)，空间复杂度O(n ^ 2)
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        int len = s.length();
        int start = 0, end = 1;

        boolean[][] isPali = new boolean[len][len];
        //长度为1，总是回文
        for (int i = 0; i < len; i++) {
            isPali[i][i] = true;
        }

        int l = 2;
        while (l <= s.length()) {
            if (l == 2) {
                for (int i = 0; i < s.length() - l + 1; i++) {
                    boolean tmp = s.charAt(i) == s.charAt(i + l - 1);
                    isPali[i][i + l - 1] = tmp;
                    if (tmp) {
                        start = i;
                        end = i + l;
                    }
                }
            } else {
                for (int i = 0; i < s.length() - l + 1; i++) {
                    boolean tmp = isPali[i + 1][i + l - 2] & s.charAt(i) == s.charAt(i + l - 1);
                    isPali[i][i + l - 1] = tmp;
                    if (tmp) {
                        start = i;
                        end = i + l;
                    }
                }
            }
            l++;
        }
        return s.substring(start, end);
    }

    /**
     * 方法二：中心扩展算法
     * 算法思路与方法一略有不同，没有保存短字符串是否为回文，而是从任意一个长度开始，从中心向两边扩展，计算最大的长度和起始位置。
     * 时间复杂度O(n ^ 2),空间复杂度O(1)
     * @param s
     * @return
     */
    public int start;
    public int len;

    public String longestPalindrome2(String s) {
        if (s.length() <= 1) {
            return s;
        }

        for (int i = 0; i < s.length(); i++) {

            helper(i, i, s);
            helper(i, i + 1, s);
        }

        return s.substring(start, start + len);
    }

    public void helper(int start, int end, String s) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        //因为此时start, end不相等
        int tmp = end - start - 1;
        if (tmp > len) {
            len = tmp;
            this.start = start + 1;
        }
    }
}
