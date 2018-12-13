package leetcode.array_string.bitmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DoubleArray954 {
    public static void main(String[] args) {
        DoubleArray954 doubleArray954 = new DoubleArray954();
        System.out.println(doubleArray954.canReorderDoubled(new int[]{1, 2, 4, 8, 16, 32, -2, -4, -1, -2, -2, -6}));
    }
// 前提是数组有序，正数是升序，负数是降序。这样从前向后匹配或从后向前匹配不会出错，如果乱序寻找第一个匹配会出现2,4,8,1，发现2和4匹配，但8和1不匹配

    /**
     * 方法一：匹配相消法。匹配后删除元素，减少冗余判断，不会超时，但比较慢，因为时间复杂度为O(n ^ 2 / 4)
     *
     * @param A
     * @return
     */
    public boolean canReorderDoubled(int[] A) {
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();
        int zeroCount = 0;
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0) {
                if (negative.isEmpty()) {
                    negative.add(A[i]);
                } else {
                    negative.add(0, A[i]);
                }
            } else if (A[i] == 0) {
                zeroCount++;
            } else {
                positive.add(A[i]);
            }
        }

        if (positive.size() % 2 != 0 || negative.size() % 2 != 0 || zeroCount % 2 != 0) {
            return false;
        }

        while (positive.size() != 0) {
            int begin = positive.get(0);
            int index = positive.indexOf(begin * 2);
            if (index == -1) {
                return false;
            }
            positive.remove(index);
            positive.remove(0);
        }

        while (negative.size() != 0) {
            int begin = negative.get(0);
            int index = negative.indexOf(begin * 2);
            if (index == -1) {
                return false;
            } else {
                negative.remove(index);
                negative.remove(0);
            }
        }
        return true;
    }

    /**
     * 方法二：bitmap法，用很多内存，用数字做下标，但查找是O（1），最快
     *
     * @param A
     * @return
     */
    public boolean canReorderDoubled2(int[] A) {
        int[] pos = new int[100001];
        int[] neg = new int[100001];
        for (int i : A) {
            if (i > 0) pos[i]++;
            else neg[-i]++;
        }
        int len1 = pos.length;
        int len2 = neg.length;
        for (int i = len1 - 1; i >= 0; i--) {
            if (pos[i] > 0) {
                while (pos[i] > 0) {
                    if (i % 2 == 1) return false;
                    pos[i]--;
                    if (pos[i / 2] == 0) return false;
                    pos[i / 2]--;
                }

            }
        }
        for (int i = len2 - 1; i >= 0; i--) {
            if (neg[i] > 0) {
                while (neg[i] > 0) {
                    if (i % 2 == 1) return false;
                    neg[i]--;
                    if (neg[i / 2] == 0) return false;
                    neg[i / 2]--;
                }
            }
        }
        return true;
    }
}
