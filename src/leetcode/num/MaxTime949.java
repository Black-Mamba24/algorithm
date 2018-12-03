package leetcode.num;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定数字能组成的最大时间
 * 给定一个由 4 位数字组成的数组，返回可以设置的符合 24 小时制的最大时间。
 * 最小的 24 小时制时间是 00:00，而最大的是 23:59。从 00:00 （午夜）开始算起，过得越久，时间越大。
 * 以长度为 5 的字符串返回答案。如果不能确定有效时间，则返回空字符串。
 * 示例 1：
 *
 * 输入：[1,2,3,4]
 * 输出："23:41"
 * 思路：kk是关键
 */
public class MaxTime949 {
    public String largestTimeFromDigits(int[] A) {
        Arrays.sort(A);
        LinkedList<Integer> list = new LinkedList<>();
        for (int i : A) {
            list.add(i);
        }

        List<Integer> kk = new ArrayList<>();
        kk.add(2);
        kk.add(1);
        kk.add(0);

        for (int k : kk) {
            LinkedList<Integer> tmpList = new LinkedList<>(list);
            String res = "";
            int max = -1;

            if (tmpList.contains(k)) {
                switch (k) {
                    case 2:
                        res += "2";
                        tmpList.remove(new Integer(2));
                        for (int i : tmpList) {
                            if (i > max && i < 4) {
                                max = i;
                            }
                        }
                        break;
                    case 1:
                        res += "1";
                        tmpList.remove(new Integer("1"));
                        for (int i : tmpList) {
                            if (i > max && i <= 9) {
                                max = i;
                            }
                        }
                        break;
                    case 0:
                        res += "0";
                        tmpList.remove(new Integer("0"));
                        for (int i : tmpList) {
                            if (i > max && i <= 9) {
                                max = i;
                            }
                        }
                        break;
                }
            }
            if (max < 0) {
                continue;
            } else {
                res += max;
            }
            tmpList.remove(new Integer(max));
            int tmp = 0;
            if (tmpList.getLast() > 5 && tmpList.getLast() <= 9) {
                tmp = 10 * tmpList.getFirst() + tmpList.getLast();
            } else {
                tmp = 10 * tmpList.getLast() + tmpList.getFirst();
            }
            if (tmp > 59) {
                continue;
            }

            if (tmp <= 9) {
                return res + ":" + "0" + tmp;
            } else {
                return res + ":" + tmp;
            }
        }
        return "";
    }
}
