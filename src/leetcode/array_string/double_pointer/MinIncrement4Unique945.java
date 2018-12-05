package leetcode.array_string.double_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 使数组唯一的最小增量
 * 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
 * 返回使 A 中的每个值都是唯一的最少操作次数。
 * 示例 1:
 * <p>
 * 输入：[1,2,2]
 * 输出：1
 * 解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
 *
 * 思路：双指针，分别指向前后两个元素，使cur永远比last大1
 */
public class MinIncrement4Unique945 {
    public static void main(String[] args) {
        MinIncrement4Unique945 minIncrement4Unique945 = new MinIncrement4Unique945();
        List<int[]> arrs = new ArrayList<>();
        arrs.add(new int[]{1, 2, 2});
        arrs.add(new int[]{3, 2, 1, 2, 1, 7});
        for (int[] arr : arrs) {
            System.out.println(minIncrement4Unique945.minIncrementForUnique(arr));
        }
    }

    public int minIncrementForUnique(int[] A) {
        if (A.length <= 1) {
            return 0;
        }
        Arrays.sort(A);
        int last = 0, cur = 1, res = 0;
        while (cur < A.length) {
            if (A[cur] <= A[last]) {
                int tmp = A[cur];
                A[cur] = A[last] + 1;
                res += (A[cur] - tmp);
            }
            cur++;
            last++;
        }
        return res;
    }
}
