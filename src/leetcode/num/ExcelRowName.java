package leetcode.num;

/**
 *
 * Created by zhaiyi on 2018/9/4.
 */
public class ExcelRowName {
    /**
     *
     给定一个正整数，返回它在 Excel 表中相对应的列名称。

     例如，

     1 -> A
     2 -> B
     3 -> C
     ...
     26 -> Z
     27 -> AA
     28 -> AB
     * @param n
     * @return
     */
    public String convertToTitle(int n) {
        String result = "";
        while (n > 0) {
            int yu = n % 26 == 0 ? 26 : n % 26;
            n -= yu;
            n /= 26;
            result = (char) (64 + yu) + result;
        }
        return result;
    }

    /**
     *
     给定一个Excel表格中的列名称，返回其相应的列序号。

     例如，

     A -> 1
     B -> 2
     C -> 3
     ...
     Z -> 26
     AA -> 27
     AB -> 28
     ...
     示例 1:

     输入: "A"
     输出: 1
     示例 2:

     输入: "AB"
     输出: 28
     * @param s
     * @return
     */
    public int titleToNumber(String s) {
        int result = 0, x = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            int tmp = (int) s.charAt(i) - 64;
            tmp *= x;
            result += tmp;
            x *= 26;
        }
        return result;
    }
}
