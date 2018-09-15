package leetcode.array_string.double_pointer;

/**
 * 实现 strStr() 函数。

 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

 示例 1:

 输入: haystack = "hello", needle = "ll"
 输出: 2
 示例 2:

 输入: haystack = "aaaaa", needle = "bba"
 输出: -1

 思路：明显的双指针法
 * Created by zhaiyi on 2018/8/25.
 */
public class StrStr {
    public static void main(String[] args) {
        StrStr strStr = new StrStr();
        System.out.println(strStr.strStr("mississippi", "a"));
    }

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.equals("")) {
            return 0;
        }

        for (int i = 0;i < haystack.length(); i++) {
            int j = 0;
            int tmp = i;
            while (i < haystack.length() && j < needle.length()) {
                if (haystack.charAt(i) == needle.charAt(j)) {
                    i++;
                    j++;
                } else {
                    break;
                }
            }

            if (j == needle.length()) {
                return tmp;
            } else {
                i = tmp;
            }
        }
        return -1;
    }
}
