package leetcode.hashmap;

import java.util.*;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 示例 1:

 输入: s = "anagram", t = "nagaram"
 输出: true
 示例 2:

 输入: s = "rat", t = "car"
 输出: false
 说明:
 你可以假设字符串只包含小写字母。
 * Created by zhaiyi on 2018/9/8.
 */
public class Anagram242 {
    public static void main(String[] args) {
        Anagram242 anagram242 = new Anagram242();
        System.out.println(anagram242.isAnagram("dgqztusjuu","dqugjzutsu"));
    }
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null || s.equals("") && s.equals("")) {
            return true;
        } else if (s.length() != t.length()) {
            return false;
        } else {
            Map<String, Integer> map = new HashMap<>();
            for(int i = 0; i < s.length(); i++) {
                if (map.containsKey(s.charAt(i) + "t")) {
                    map.put(s.charAt(i) + "t", map.get(s.charAt(i) + "t") - 1);
                } else if (!map.containsKey(s.charAt(i) + "s")) {
                    map.put(s.charAt(i) + "s", 1);
                } else {
                    map.put(s.charAt(i) + "s", map.get(s.charAt(i) + "s") + 1);
                }

                if (map.containsKey(t.charAt(i) + "s")) {
                    map.put(t.charAt(i) + "s", map.get(t.charAt(i) + "s") - 1);
                } else if (!map.containsKey(t.charAt(i) + "t")) {
                    map.put(t.charAt(i) + "t", 1);
                } else {
                    map.put(t.charAt(i) + "t", map.get(t.charAt(i) + "t") + 1);
                }

            }
            for (int v : map.values()) {
                if (v != 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
