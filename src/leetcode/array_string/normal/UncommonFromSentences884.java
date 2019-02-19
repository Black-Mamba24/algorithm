package leetcode.array_string.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import leetcode.ListNode;

/**
 * 给定两个句子 A 和 B 。 （句子是一串由空格分隔的单词。每个单词仅由小写字母组成。）
 * 如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么这个单词就是不常见的。
 * 返回所有不常用单词的列表。
 * 您可以按任何顺序返回列表。
 * Created by zhaiyi on 2019/2/16.
 */
public class UncommonFromSentences884 {
    public String[] uncommonFromSentences(String A, String B) {
        ArrayList<String> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : A.split(" ")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (String s : B.split(" ")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                list.add(entry.getKey());
            }
        }
        String[] res = new String[list.size()];
        return list.toArray(res);
    }

    public String[] uncommonFromSentences2(String A, String B) {
        Map<String, Integer> count = new HashMap<>();
        for (String str : (A + " " + B).split(" "))
            count.put(str, count.getOrDefault(str, 0) + 1);
        List<String> res = new ArrayList<>();
        for (String key : count.keySet())
            if (count.get(key) == 1)
                res.add(key);
        return res.toArray(new String[0]);
    }

    public static void main(String[] args) {
        UncommonFromSentences884 uncommonFromSentences884 = new UncommonFromSentences884();
        uncommonFromSentences884.uncommonFromSentences("this apple is sweet", "this apple is sour");
    }
}
