package leetcode.array_string.normal;

/**
 *
 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。

 示例 1:

 输入: "abab"

 输出: True

 解释: 可由子字符串 "ab" 重复两次构成。

 思路：此题应从s.length() / 2开始遍历，防止内存超限，s.length() % i == 0提高效率
 * Created by zhaiyi on 2018/9/19.
 */
public class RepeatedSubstring459 {
    public boolean repeatedSubstringPattern(String s) {
        for (int i = s.length() / 2; i >= 1; i--) {
            if (s.length() % i == 0) {
                String tmp = null;
                boolean ok = true;
                int j = 0;
                for (; j < s.length(); j+=i) {
                    if (tmp == null) {
                        tmp = s.substring(j, j + i);
                    } else {
                        if (j + i > s.length() || !s.substring(j, j + i).equals(tmp)) {
                            ok = false;
                            break;
                        }
                    }
                }
                if (ok && j == s.length()) {
                    return true;
                }
            }
        }
        return false;
    }
}
