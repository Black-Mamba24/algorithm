package leetcode.recursion.back_tracking;

import java.util.ArrayList;
import java.util.List;

public class Combine77 {
    public static void main(String[] args) {
        Combine77 combine77 = new Combine77();
        List<List<Integer>> res = combine77.combine(4, 2);
        for (List<Integer> l : res) {
            System.out.println(l);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] b = new boolean[n];
        find(b, k, 0, res);
        return res;
    }

    public void find(boolean[] b, int left, int start, List<List<Integer>> res) {
        if (left == 0) {
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < b.length; i++) {
                if (b[i]) {
                    l.add(i + 1);
                }
            }
            res.add(l);
        } else if (start < b.length) {
            b[start] = true;
            find(b, left - 1, start + 1, res);
            b[start] = false;
            find(b, left, start + 1, res);
        }
    }
}
