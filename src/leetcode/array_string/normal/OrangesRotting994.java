package leetcode.array_string.normal;

import java.util.HashSet;
import java.util.Set;

/**
 * 在给定的网格中，每个单元格可以有以下三个值之一：

 值 0 代表空单元格；
 值 1 代表新鲜橘子；
 值 2 代表腐烂的橘子。
 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。

 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。

 输入：[[2,1,1],[1,1,0],[0,1,1]]
 输出：4

 输入：[[2,1,1],[0,1,1],[1,0,1]]
 输出：-1
 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
 * Created by zhaiyi on 2019/2/17.
 */
public class OrangesRotting994 {
    public static void main(String[] args) {
        OrangesRotting994 orangesRotting994 = new OrangesRotting994();
        System.out.println(orangesRotting994.orangesRotting(new int[][] {
            {2, 1, 1},
            {1,1,0},
            {0,1,1}
        }));
    }

    class Item {
        int i;
        int j;

        Item(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int orangesRotting(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int min = 0;
        int row = grid.length, col = grid[0].length;
        int flag;
        while (true) {
            Set<Item> set = new HashSet<>();
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == 1) {
                        set.add(new Item(i, j));
                    }
                }
            }
            if (set.isEmpty()) {
                flag = 1;
                break;
            }
            min++;
            boolean change = false;
            for (Item item : set) {
                int i = item.i;
                int j = item.j;
                if (i - 1 >= 0 && grid[i - 1][j] == 2 || i + 1 < row && grid[i + 1][j] == 2 ||
                    j - 1 >= 0 && grid[i][j - 1] == 2 || j + 1 < col && grid[i][j + 1] == 2) {
                    grid[i][j] = 3;
                    change = true;
                }
            }
            if (!change) {
                flag = 2;
                break;
            }

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == 3) {
                        grid[i][j] = 2;
                    }
                }
            }
        }
        return flag == 1 ? min : -1;
    }
}


