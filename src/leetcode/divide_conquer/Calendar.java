package leetcode.divide_conquer;

/**
 * 循环赛日程表问题
 * 有2 ^ k个队伍，循环比赛，每个队都要与其他2 ^ k - 1个队伍比一次，且每个队伍一天只能有一场比萨。
 * 要求在最少天数内比完。
 * Created by zhaiyi on 2018/10/16.
 */
public class Calendar {
    public static void main(String[] args) {
        int n = 8;
        int [][] res = calendar(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] calendar(int n) {
        int[][] calendar = new int[n][n];
        for (int i = 0; i < n; i++) {
            calendar[0][i] = i + 1;
        }
        for (int r = 1; r < n; r <<= 1) {
            for (int i = 0; i < n; i += 2 * r) {
                copy(calendar, 0, i, r, i + r, r);
                copy(calendar, 0, i + r, r, i, r);
            }
        }
        return calendar;
    }

    public static void copy(int[][] calendar, int fromx, int fromy, int tox, int toy, int r) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < r; j++) {
                calendar[tox + i][toy + j] = calendar[fromx + i][fromy + j];
            }
        }
    }
}
