package leetcode.array_string.normal;

import java.util.HashMap;
import java.util.Map;

/**
 * 验证外星语词典
 * 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
 * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
 *
 * 输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * 输出：true
 * 解释：在该语言的字母表中，'h' 位于 'l' 之前，所以单词序列是按字典序排列的。
 *
 * 输入：words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * 输出：false
 * 解释：在该语言的字母表中，'d' 位于 'l' 之后，那么 words[0] > words[1]，因此单词序列不是按字典序排列的。
 *
 * 输入：words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * 输出：false
 * 解释：当前三个字符 "app" 匹配时，第二个字符串相对短一些，然后根据词典编纂规则 "apple" > "app"。
 */
public class AlienWord953 {
    public static void main(String[] args) {
        AlienWord953 alienWord953 = new AlienWord953();
        System.out.println(alienWord953.isAlienSorted(new String[]{"app","app"}, "abcdefghijklmnopqrstuvwxyz"));
    }
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        int i = 0;
        int max = -1;
        for (String s : words) {
            max = Math.max(max, s.length());
        }
        for (int x = 0; x < max; x++) {
            int last = -1, cur = -1;
            boolean ifContinue = false;
            for (String s : words) {
                last = cur;
                if (i < s.length()) {
                    cur = map.get(s.charAt(i));
                } else {
                    cur = -1;
                }
                if (cur < last) {
                    return false;
                } else if(cur == last) {
                    ifContinue = true;
                }
            }
            if (!ifContinue) {
                return true;
            }
            i++;
        }
        return true;
    }
}
