package leetcode.subarray.double_pointer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。

 示例 1:

 输入: "abcabcbb"
 输出: 3
 解释: 无重复字符的最长子串是 "abc"，其长度为 3。

 思路：此题首先想到hash表法，计算连续子串长度，下标后减前，因此也是双指针法。双指针形成滑动窗口
 问题的关键是滑动窗口的移动，当集合中不重复时，右边界递增，计算max即可。当重复时，左边界需要按顺序移动直到集合中不重复为止。
 如果使用map记录<char, index>，更新index时还要将map中index < 重复值的index删掉，因此使用set最佳。

 * Created by zhaiyi on 2018/9/19.
 */
public class LongestSubstringNoDup3 {
    public static void main(String[] args) {
        LongestSubstringNoDup3 longestSubstringNoDup = new LongestSubstringNoDup3();
        String [] strings = new String[] {"tmmzuxt", "a", "av", "ava", "abba", "abcabcbb", "bbbbb", "pwwkew", "dvdf"};
        for (String s : strings) {
            System.out.println(s + "   " + longestSubstringNoDup.lengthOfLongestSubstring(s));
        }
    }

    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();
        while(i < s.length() && j < s.length()) {
            char c = s.charAt(j);
            if (!set.contains(c)) {
                set.add(c);
                max = Math.max(max, j++ - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return max;
     }
}
