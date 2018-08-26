package leetcode.simple;

/**
 * 报数序列是指一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 6.     312211
 * 7.     13112221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * Created by zhaiyi on 2018/8/25.
 */
public class CountAndSay {
    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        System.out.println(countAndSay.countAndSay(6));
    }

    public String countAndSay(int n) {
        String result = "1";
        for (int i = 2; i <= n; i++) {
            String tmpStr = "";
            for (int j = 0; j < result.length(); ) {
                int tmp = j;
                while (j < result.length() && result.charAt(j) == result.charAt(tmp)) {
                    j++;
                }
                int delta = j - tmp;
                tmpStr += String.valueOf(delta);
                tmpStr += String.valueOf(result.charAt(tmp));
            }
            result = tmpStr;
        }
        return result;
    }
}
