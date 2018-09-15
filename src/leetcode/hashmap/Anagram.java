package leetcode.hashmap;

import java.util.*;

/**
 * Created by zhaiyi on 2018/9/8.
 */
public class Anagram {
    public static void main(String[] args) {
        Anagram anagram = new Anagram();
        System.out.println(anagram.isAnagram("dgqztusjuu","dqugjzutsu"));
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
