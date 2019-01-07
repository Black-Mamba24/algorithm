package leetcode.dp;

public class NumberOfArithmeticSlices413 {
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int[] dp = new int[A.length];
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        int res = 0;
        for (int r : dp) {
            res += r;
        }
        return res;
    }

    public static void main(String[] args) {
        NumberOfArithmeticSlices413 numberOfArithmeticSlices413 = new NumberOfArithmeticSlices413();
        numberOfArithmeticSlices413.numberOfArithmeticSlices(new int[]{1,2,3,4});
    }
}
