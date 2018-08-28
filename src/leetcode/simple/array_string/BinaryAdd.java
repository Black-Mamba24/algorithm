package leetcode.simple.array_string;

/**
 *
 给定两个二进制字符串，返回他们的和（用二进制表示）。

 输入为非空字符串且只包含数字 1 和 0。
 * Created by zhaiyi on 2018/8/27.
 */
public class BinaryAdd {
    public static void main(String[] args) {
        BinaryAdd binaryAdd = new BinaryAdd();
        System.out.println(binaryAdd.addBinary("111", "11"));
    }

    public String addBinary(String a, String b) {
        if (a == null || a.equals("")) {
            return b;
        }
        if (b == null || b.equals("")) {
            return a;
        }
        String result = "";
        String big = a.length() > b.length() ? a : b;
        String small = a.length() > b.length() ? b : a;
        int prof = 0;
        int delta = big.length() - small.length();
        for (int i = big.length() -1 ; i >= 0; i--) {
            int tmp;
            int j = i - delta;
            if (j >= 0) {
                tmp = Integer.parseInt(small.charAt(j)+"") + Integer.parseInt(big.charAt(i)+"") + prof;
            } else {
                tmp = Integer.parseInt(big.charAt(i)+"") + prof;
            }
            int newV = tmp % 2;
            prof = tmp / 2;
            result = newV + result;
        }

        if (prof == 1) {
            result = "1" + result;
        }
        return result;
    }
}
