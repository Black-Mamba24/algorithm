package leetcode.array_string.normal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 你有一个单词列表 words 和一个模式  pattern，你想知道 words 中的哪些单词与模式匹配。
 如果存在字母的排列 p ，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。
 （回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。）
 返回 words 中与给定模式匹配的单词列表。
 你可以按任何顺序返回答案。
 * Created by zhaiyi on 2019/1/27.
 */
public class FindAndReplacePattern890 {
    public static void main(String[] args) {
        FindAndReplacePattern890 findAndReplacePattern890 = new FindAndReplacePattern890();
        System.out.println(findAndReplacePattern890.findAndReplacePattern(new String[] {"abc", "deq", "mee", "aqq", "dkd", "ccc"}, "abb"));
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        char[] patterns = pattern.toCharArray();
        List<String> res = new ArrayList<>();
        Map<Character, Character> map = new HashMap<>();
        for (String word : words) {
            if (word.length() == pattern.length()) {
                int i = 0;
                for (; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (!map.containsKey(c)) {
                        if (map.values().contains(patterns[i])) {
                            break;
                        }
                        map.put(c, patterns[i]);
                    } else {
                        if (map.get(c) != patterns[i]) {
                            break;
                        }
                    }
                }
                if (i == word.length()) {
                    res.add(word);
                }
                map.clear();
            }
        }
        return res;
    }
}
