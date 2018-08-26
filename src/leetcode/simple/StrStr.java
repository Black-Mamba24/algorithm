package leetcode.simple;

/**
 * Created by zhaiyi on 2018/8/25.
 */
public class StrStr {
    public static void main(String[] args) {
        StrStr strStr = new StrStr();
        System.out.println(strStr.strStr("mississippi", "a"));
    }

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.equals("")) {
            return 0;
        }

        for (int i = 0;i < haystack.length(); i++) {
            int j = 0;
            int tmp = i;
            while (i < haystack.length() && j < needle.length()) {
                if (haystack.charAt(i) == needle.charAt(j)) {
                    i++;
                    j++;
                } else {
                    break;
                }
            }

            if (j == needle.length()) {
                return tmp;
            } else {
                i = tmp;
            }
        }
        return -1;
    }
}
