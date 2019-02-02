package leetcode.recursion.back_tracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class NQueue51_Better {
    private Set<Integer> pie = new HashSet<>(), na = new HashSet<>();
    private SortedMap<Integer, Integer> queues = new TreeMap<>();
    private List<List<String>> res = new ArrayList<>();

    public static void main(String[] args) {
        NQueue51_Better nQueue51_better = new NQueue51_Better();
        nQueue51_better.solveNQueens(4);
    }

    public List<List<String>> solveNQueens(int n) {
        find(0, n);
        return res;
    }

    public void find(int line, int n) {
        if (line == n) {
            List<String> r = new ArrayList<>();
            for (Map.Entry<Integer, Integer> queue : queues.entrySet()) {
                StringBuilder sb = new StringBuilder();
                int row = queue.getValue();
                for (int i = 0; i < n; i++) {
                    if (i == row) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                r.add(sb.toString());
            }
            res.add(r);
        } else {
            for (int row = 0; row < n; row++) {
                if (queues.values().contains(row) || pie.contains(line + row) || na.contains(line - row)) {
                    continue;
                }
                queues.put(line, row);
                pie.add(line + row);
                na.add(line - row);
                find(line + 1, n);
                queues.remove(line, row);
                pie.remove(line + row);
                na.remove(line - row);
            }
        }
    }
}
