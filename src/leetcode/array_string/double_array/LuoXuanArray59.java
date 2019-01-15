package leetcode.array_string.double_array;

/**
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * 示例:
 * 输入: 3
 * 输出:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 */
public class LuoXuanArray59 {
    public static void main(String[] args) {
        LuoXuanArray59 luoXuanArray59 = new LuoXuanArray59();
        int[][] res = luoXuanArray59.generateMatrix(3);
        for (int[] r : res) {
            for (int i = 0; i < r.length; i++) {
                System.out.print(r[i] + " ");
            }
            System.out.println();
        }
    }

    public int[][] generateMatrix(int n) {
        int i = 0, j = 0;
        int[][] des = new int[][]{
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0}
        };
        int des_index = 0;
        int[][] res = new int[n][n];
        for (int num = 1; num <= n * n; num++) {
            res[i][j] = num;
            switch (des_index) {
                case 0:
                    if (j + 1 >= n || res[i][j + 1] != 0) {
                        des_index = ++des_index % 4;
                    }
                    break;
                case 1:
                    if (i + 1 >= n || res[i + 1][j] != 0) {
                        des_index = ++des_index % 4;
                    }
                    break;
                case 2:
                    if (j - 1 < 0 || res[i][j - 1] != 0) {
                        des_index = ++des_index % 4;
                    }
                    break;
                case 3:
                    if (i - 1 < 0 || res[i - 1][j] != 0) {
                        des_index = ++des_index % 4;
                    }
                    break;
            }

            i += des[des_index][0];
            j += des[des_index][1];
        }
        return res;
    }
}
