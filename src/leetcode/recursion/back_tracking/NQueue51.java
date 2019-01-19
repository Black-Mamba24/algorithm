package leetcode.recursion.back_tracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueue51 {
    public static void main(String[] args) {
        NQueue51 nQueue51 = new NQueue51();
        System.out.println(nQueue51.solveNQueens(4));
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        find(n, n, res, new HashSet<>());
        return res;
    }

    public void find(int n, int left, List<List<String>> res, Set<Long> queue) {
        if (left == 0) {
            List<String> l = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    long tmp = getLong(i, j);
                    if (queue.contains(tmp)) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                l.add(sb.toString());
            }
            res.add(l);
        } else {
            int i = n - left;
            for (int j = 0; j < n; j++) {
                boolean flag = true;
                for (long q : queue) {
                    int row = (int) (q);
                    q >>= 32;
                    int line = (int) (q);
                    if (j == row || Math.abs(line - i) == Math.abs(row - j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    long tmp = getLong(i, j);
                    queue.add(tmp);
                    find(n, left - 1, res, queue);
                    queue.remove(tmp);
                }
            }
        }
    }

    public long getLong(int i, int j) {
        long tmp = 0;
        tmp |= i;
        tmp <<= 32;
        tmp |= j;
        return tmp;
    }

}
