package leetcode.dp;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 */
public class UniquePathsWithObstacles63 {
    public static void main(String[] args) {
        UniquePathsWithObstacles63 uniquePathsWithObstacles63 = new UniquePathsWithObstacles63();
        System.out.println(uniquePathsWithObstacles63.uniquePathsWithObstacles(new int[][] {
            {0,0,0},
            {0,1,0},
            {0,0,0}
        }));
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) {
            return 0;
        }
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] paths = new int[m][n];
        boolean flag = true;
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                flag = false;
            }
            paths[i][0] = flag ? 1 : 0;
        }
        flag = true;
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                flag = false;
            }
            paths[0][i] = flag ? 1 : 0;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    if (obstacleGrid[i - 1][j] == 1) {
                        paths[i][j] = paths[i][j - 1];
                    } else if (obstacleGrid[i][j - 1] == 1) {
                        paths[i][j] = paths[i - 1][j];
                    } else {
                        paths[i][j] = paths[i][j - 1] + paths[i - 1][j];
                    }
                }
            }
        }
        return paths[m - 1][n - 1];
    }
}
