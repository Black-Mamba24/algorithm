package leetcode.dynamic_programming;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhaiyi on 2018/9/2.
 */
public class ArrayOr {
    public Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        ArrayOr arrayOr = new ArrayOr();
        arrayOr.subarrayBitwiseORs(new int[]{1,2,4});
    }

    public int subarrayBitwiseORs(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int[][] dp = new int[A.length][A.length];
        //i代表行，j代表列

        for (int x = 0; x < A.length; x ++) {
            dp[x][x] = A[x];
            set.add(dp[x][x]);
        }
        for (int i = 1; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                dp[i][j] = dp[i][j - 1] | A[j];
                set.add (dp[i][j]);
            }
        }
        return set.size();
    }
}
