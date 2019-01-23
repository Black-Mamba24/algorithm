package leetcode.array_string.normal;

import java.util.HashMap;
import java.util.Map;

public class Ransom383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magaMap = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            magaMap.put(c, magaMap.getOrDefault(c, 0) + 1);
        }

        for (char c : ransomNote.toCharArray()) {
            if (!magaMap.containsKey(c) || magaMap.get(c) == 0) {
                return false;
            }
            magaMap.put(c, magaMap.get(c) - 1);
        }
        return true;
    }

    /**
     * 最优解，对号入座，有限的key无需使用map，用数组会快很多
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct2(String ransomNote, String magazine) {
        int[] noteWord = new int[26];
        int[] magaWord = new int[26];
        char[] noteArr = ransomNote.toCharArray();
        char[] magaArr = magazine.toCharArray();
        for(char c : magaArr){
            magaWord[c - 'a'] ++;
        }
        for(char c : noteArr){
            if(-- magaWord[c - 'a'] < 0){
                return false;
            }
        }
        return true;
    }
}
