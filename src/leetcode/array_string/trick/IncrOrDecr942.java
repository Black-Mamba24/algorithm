package leetcode.array_string.trick;

/**
 * 给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。
 *
 * 返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：
 *
 * 如果 S[i] == "I"，那么 A[i] < A[i+1]
 * 如果 S[i] == "D"，那么 A[i] > A[i+1]
 *
 *
 * 示例 1：
 *
 * 输出："IDID"
 * 输出：[0,4,1,3,2]
 * 示例 2：
 *
 * 输出："III"
 * 输出：[0,1,2,3]
 */
public class IncrOrDecr942 {
    public static void main(String[] args) {
        IncrOrDecr942 incrOrDecr942 = new IncrOrDecr942();
        int[] res = incrOrDecr942.diStringMatch("I");
        for (int i : res) {
            System.out.println(i);
        }
    }
    public int[] diStringMatch(String S) {
        if (S.length() == 0) {
            return new int[0];
        }
        int len = S.length();
        int max = S.length();
        int min = 0;
        int[] res = new int[max + 1];
        if (S.charAt(0) == 'D') {
            res[0] = max;
            max--;
        } else {
            res[0] = min;
            min++;
        }
        for (int i = 1; i < len; i++) {
            String sub = "" + S.charAt(i - 1) + S.charAt(i);
            switch (sub) {
                case "II":
                case "DI":
                    res[i] = min;
                    min ++;
                    break;
                case "DD":
                case "ID":
                    res[i] = max;
                    max--;
                    break;
            }
        }
        if (S.charAt(S.length() - 1) == 'D') {
            res[len] = min;
        } else {
            res[len] = max;
        }
        return res;
    }
}
