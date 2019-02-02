package leetcode.recursion.back_tracking;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 */
public class NQueue52_Better {
    private Set<Integer> pie = new HashSet<>(), na = new HashSet<>();
    private Set<Integer> rows = new HashSet<>();
    private int res = 0;

    public int totalNQueens(int n) {
        find(0, n);
        return res;
    }

    public void find(int line, int n) {
        if (line == n) {
            res++;
        } else {
            for (int row = 0; row < n; row++) {
                if (rows.contains(row) || pie.contains(line + row) || na.contains(line - row)) {
                    continue;
                }
                rows.add(row);
                pie.add(line + row);
                na.add(line - row);
                find(line + 1, n);
                rows.remove(row);
                pie.remove(line + row);
                na.remove(line - row);
            }
        }
    }
}
