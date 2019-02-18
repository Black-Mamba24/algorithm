package leetcode.greedy;

import leetcode.tree.bst.MinDiff530;

/**
 * 在仅包含 0 和 1 的数组 A 中，一次 K 位翻转包括选择一个长度为 K 的（连续）子数组，同时将子数组中的每个 0 更改为 1，而每个 1 更改为 0。
 *
 * 返回所需的 K 位翻转的次数，以便数组没有值为 0 的元素。如果不可能，返回 -1。
 * 贪心题目，有点秀
 */
public class MinKBitFlips995 {
    public static void main(String[] args) {
        MinKBitFlips995 minKBitFlips995 = new MinKBitFlips995();
        System.out.println(minKBitFlips995.minKBitFlips(new int[] {0,0,0,1,0,1,1,0}, 5));
    }
    public int minKBitFlips(int[] A, int K) {
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                if (i + K > A.length) {
                    return -1;
                }
                res++;
                for (int j = i; j < i + K; j++) {
                    A[j] = 1 - A[j];
                }
            }
        }
        return res;
    }
}
