package leetcode.array_string.double_pointer;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

 说明：本题中，我们将空字符串定义为有效的回文串。

 示例 1:

 输入: "A man, a plan, a canal: Panama"
 输出: true
 示例 2:

 输入: "race a car"
 输出: false
 思路：明显的双指针法，唯一要注意的是相差是32的不一定都是下小写字母，例如0P
 * Created by zhaiyi on 2018/8/30.
 */
public class PalindromeString {
    public static void main(String[] args) {
        PalindromeString palindromeString = new PalindromeString();
        System.out.println(palindromeString.isPalindrome(" "));
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.equals("")) {
            return true;
        } else {
            int start = 0, end = s.length() - 1;
            while (start <= end) {
                while(start <= s.length() - 1 &&
                        !(s.charAt(start) >= 97 && s.charAt(start) <= 122 ||
                        s.charAt(start) >= 65 && s.charAt(start) <= 90 ||
                        s.charAt(start) >= 48 && s.charAt(start) <= 57)) {
                    start++;
                }
                while(end >= 0 &&
                        !(s.charAt(end) >= 97 && s.charAt(end) <= 122 ||
                        s.charAt(end) >= 65 && s.charAt(end) <= 90 ||
                        s.charAt(end) >= 48 && s.charAt(end) <= 57)) {
                    end--;
                }
                if (start <= end) {
                    if (s.charAt(start) == s.charAt(end) || s.charAt(start) >= 65 && s.charAt(start) >= 65 && Math.abs(s.charAt(start) - s.charAt(end)) == 32) {
                        start ++;
                        end --;
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
