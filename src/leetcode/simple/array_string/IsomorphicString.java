package leetcode.simple.array_string;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t，判断它们是否是同构的。

 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。

 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。

 示例 1:

 输入: s = "egg", t = "add"
 输出: true
 示例 2:

 输入: s = "foo", t = "bar"
 输出: false
 * Created by zhaiyi on 2018/9/5.
 */
public class IsomorphicString {
    public static void main(String[] args) {
        IsomorphicString isomorphicString = new IsomorphicString();
        isomorphicString.isIsomorphic("ab", "aa");
    }
    Map<Character, Character> map = new HashMap<>();
    public boolean isIsomorphic(String s, String t) {
        if (s == null && t == null || s.equals("") && t.equals("")) {
            return true;
        } else if (s != null && t != null && !s.equals("") && !t.equals("")) {
            for (int i = 0; i < s.length(); i++) {
                char s1 = s.charAt(i);
                char t1 = t.charAt(i);
                if (map.get(s1) == null) {
                    //只能一对一映射
                    if (map.values().contains(t1)) {
                        return false;
                    }
                    map.put(s1, t1);
                } else {
                    if (!map.get(s1).equals(t1)) {
                        return false;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
