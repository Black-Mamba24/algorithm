package leetcode.array_string.normal;

import java.util.*;

/**
 * 下一个更大元素 III
 * 给定一个32位正整数 n，你需要找到最小的32位整数，其与 n 中存在的位数完全相同，并且其值大于n。如果不存在这样的32位整数，则返回-1。
 *
 * 示例 1:
 * 输入: 12
 * 输出:
 *
 * 示例 2:
 * 输入: 21
 * 输出: -1
 *
 * 思路：从后项圈找第一个下降点，结果分为找不到下降点，下降点位于头部，下降点位于其他部位
 * 找不到下降点：直接返回-1
 * 下降点位于头部：找刚好大于下降点的值，其他值排序，拼接在后面，其实可以跟下降点位于其他部位合在一起
 * 下降点位于其他部位：先将头部一段复制一遍，剩余数字中再找刚好大于下降点的，其他值排序，拼接在后面
 * 题目不算很难，锻炼耐性
 * 要注意int是否越界
 */
public class NextBiggerNumer556 {
    public static void main(String[] args) {
        NextBiggerNumer556 nextBiggerNumer556 = new NextBiggerNumer556();
        int[] nums = new int[]{1999999999, 12, 21, 120, 102, 1234, 4321, 1432, 1243, 1342, 1423,80121};
        for (int n : nums) {
            System.out.println(n + "    " + nextBiggerNumer556.nextGreaterElement(n));
        }

    }

    public int nextGreaterElement(int n) {
        int tmp = n;
        List<Integer> list = new ArrayList<>();
        while (tmp != 0) {
            int x = tmp % 10;
            tmp /= 10;
            list.add(0, x);
        }

        int index = -1;
        for (int i = list.size() - 1; i > 0; i--) {
            if (list.get(i) > list.get(i - 1)) {
                index = i - 1;
                break;
            }
        }
        if (index == -1) {
            return -1;
        } else if (index == 0) {
            int value = list.get(index);
            Collections.sort(list);
            int index_ = list.indexOf(value) + 1;
            int res = list.get(index_);
            list.remove(index_);
            for (int i : list) {
                if (res > Integer.MAX_VALUE / 10 || (res  == Integer.MAX_VALUE / 10 && i > 7)) {
                    return -1;
                }
                res = res * 10 + i;
            }
            return res;
        } else {
            List<Integer> newList = new ArrayList<>();
            for (int i = 0; i < index; i++) {
                newList.add(list.get(i));
            }
            for (int i = 0; i < index; i++) {
                list.remove(0);
            }
            int value = list.get(0);
            Collections.sort(list);
            int index_ = list.lastIndexOf(value) + 1;
            value = list.get(index_);
            list.remove(index_);
            int res = 0;
            for (int i : newList) {
                if (res > Integer.MAX_VALUE / 10 || (res  == Integer.MAX_VALUE / 10 && i > 7)) {
                    return -1;
                }
                res = res * 10 + i;
            }
            res = res * 10 + value;
            for (int i : list) {
                if (res > Integer.MAX_VALUE / 10 || (res  == Integer.MAX_VALUE / 10 && i > 7)) {
                    return -1;
                }
                res = res * 10 + i;
            }
            return res;
        }
    }
}
