package leetcode.array_string.double_array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaiyi on 2018/10/31.
 */
public class ZConvert6 {
    public static void main(String[] args) {
        ZConvert6 zConvert6 = new ZConvert6();
        System.out.println(zConvert6.convert("AB", 1));
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        char[] chars = s.toCharArray();
        boolean godwon = false;
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            list.get(index).append(chars[i]);
            if (index == 0 || index == numRows - 1) {
                godwon = !godwon;
            }
            if (godwon) {
                index++;
            } else {
                index--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            sb.append(list.get(i).toString());
        }
        return sb.toString();
    }

}
