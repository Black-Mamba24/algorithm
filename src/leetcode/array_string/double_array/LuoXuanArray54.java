package leetcode.array_string.double_array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LuoXuanArray54 {
    public static void main(String[] args) {
        LuoXuanArray54 luoXuanArray54 = new LuoXuanArray54();
        System.out.println(luoXuanArray54.spiralOrder(new int[][]{
                {1, 2, 3, 4},
                {10, 11, 12, 5},
                {9, 8, 7, 6}
        }));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        List<Integer> ans = new ArrayList<>();
        if (m <= 0) {
            return ans;
        }
        int n = matrix[0].length;

        int[][] dx = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] f = new boolean[m][n];
        int cur = 0;
        int i = 0, j = 0;
        for (int x = 0; x < m * n; x++) {
            ans.add(matrix[i][j]);
            f[i][j] = true;
            if (i + dx[cur][0] >= m || i + dx[cur][0] < 0
                    || j + dx[cur][1] >= n || j + dx[cur][1] < 0
                    || f[i + dx[cur][0]][j + dx[cur][1]]) {
                cur = (cur + 1) % 4;
            }
            i += dx[cur][0];
            j += dx[cur][1];
        }
        return ans;
    }
}
