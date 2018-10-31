package leetcode;

/**
 * Created by zhaiyi on 2018/10/28.
 */
public class Main3 {
    public static void main(String[] args) {
        Main3 main3 = new Main3();
        System.out.println(main3.minFallingPathSum(new int[][]{
                {-80,-13,22},
                {83,94,-5},
                {73,-48,61}
        }));
    }
    public int minFallingPathSum(int[][] A) {
        if (A.length == 0) {
            return 0;
        }
        int len = A.length;
        int [][] res = new int[len][len];
        int [] index = new int[len];
        for (int i = 0; i < len; i++) {
            index[i] = i;
        }

        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j < len; j++) {
                if (i == len - 1) {
                    res[i][j] = A[i][j];
                } else {
                    int min_index = j;
                    int min = A[i][index[j]];
                    if (index[j] - 1 >=0) {
                        min = Math.min (min, A[i][index[j] - 1]);
                        min_index = j - 1;
                    }
                    if (index[j] + 1 <len) {
                        min = Math.min (min, A[i][index[j] + 1]);
                        min_index = j + 1;
                    }
                    res[i][j] = res [i + 1][j] + min;
                    index[j] = min_index;
                }
            }
        }

        int min = res[0][0];
        for (int i = 1; i < len; i++) {
            min = Math.min(min, res[0][i]);
        }
        return min;
    }
}
