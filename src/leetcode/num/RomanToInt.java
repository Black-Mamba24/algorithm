package leetcode.num;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 罗马数字包含以下七种字符：I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * IV            4
 * IX            9
 * XL            40
 * XC            90
 * 关键点是前一个数<后一个数，则用后一个数-前一个数，否则从前向后一次累加
 * Created by zhaiyi on 2018/8/24.
 */
public class RomanToInt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        if (s == null || s.equals("")) {
            System.out.println(0);
            return;
        }
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        int res = 0;
        int i = 0;

        for (; i < s.length() - 1; i++) {
            int first = map.get(s.charAt(i) + "");
            int second = map.get(s.charAt(i + 1) + "");
            if (first >= second) {
                res += first;
            } else {
                res += (second - first);
                i++;
            }
        }
        if (i == s.length() - 1) {
            res += map.get(s.charAt(i) + "");
        }

        System.out.println(res);
    }
}
