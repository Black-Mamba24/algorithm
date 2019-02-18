package leetcode;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.sumEvenAfterQueries(new int[] {1, 2, 3, 4}, new int[][] {
            {1, 0},
            {-3, 1},
            {-4, 0},
            {2, 3}
        });
    }

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
