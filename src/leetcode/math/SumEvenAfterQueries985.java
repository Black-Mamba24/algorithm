package leetcode.math;

/**
 *
 给出一个整数数组 A 和一个查询数组 queries。
 对于第 i 次查询，有 val = queries[i][0], index = queries[i][1]，我们会把 val 加到 A[index] 上。然后，第 i 次查询的答案是 A 中偶数值的和。
 （此处给定的 index = queries[i][1] 是从 0 开始的索引，每次查询都会永久修改数组 A。）
 返回所有查询的答案。你的答案应当以数组 answer 给出，answer[i] 为第 i 次查询的答案。
 * Created by zhaiyi on 2019/2/12.
 */
public class SumEvenAfterQueries985 {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] res = new int[A.length];
        int sum = 0;
        for (int n : A) {
            if (n % 2 == 0) {
                sum += n;
            }
        }
        for (int i = 0; i < queries.length; i++) {
            int val = queries[i][0];
            int index = queries[i][1];
            if (A[index] % 2 == 0 && val % 2 == 0) {
                sum += val;
            } else if (A[index] % 2 == 0 && Math.abs(val % 2) == 1) {
                sum -= A[index];
            } else if (Math.abs(A[index] % 2) == 1 && Math.abs(val % 2) == 1) {
                sum += (val + A[index]);
            }
            res[i] = sum;
            A[index] += val;
        }
        return res;
    }
}
