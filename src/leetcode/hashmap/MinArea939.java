package leetcode.hashmap;

import java.util.*;

/**
 * 给定在 xy 平面上的一组点，确定由这些点组成的矩形的最小面积，其中矩形的边平行于 x 轴和 y 轴。
 *
 * 如果没有任何矩形，就返回 0。
 * 示例 1：
 * 输入：[[1,1],[1,3],[3,1],[3,3],[2,2]]
 * 输出：4
 */
public class MinArea939 {
    public static void main(String[] args) {
        MinArea939 minArea939 = new MinArea939();
        System.out.println(minArea939.minAreaRect(new int[][]{
                {3, 2},
                {1, 3},
                {3, 3},
                {3, 0},
                {3, 1},
                {2, 0},
                {4, 2},
                {1, 0},
                {4, 1},
                {1, 1}
        }));
    }

    public int minAreaRect(int[][] points) {
        int res = 0;
        Set<Long> set = new HashSet<>();
        Map<Integer, SortedSet<Integer>> y2x = new HashMap<>();
        Map<Integer, SortedSet<Integer>> x2y = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            long l = 0;
            l |= x;
            l <<= 32;
            l |= y;
            set.add(l);
            if (!y2x.containsKey(y)) {
                y2x.put(y, new TreeSet<>());
            }
            if (!x2y.containsKey(x)) {
                x2y.put(x, new TreeSet<>());
            }
            y2x.get(y).add(x);
            x2y.get(x).add(y);
        }

        for (Map.Entry<Integer, SortedSet<Integer>> y2x_entry : y2x.entrySet()) {
            int y = y2x_entry.getKey();
            SortedSet<Integer> x_set = y2x_entry.getValue();
            for (int x : x_set) {
                SortedSet<Integer> x_sub = x_set.tailSet(x);
                SortedSet<Integer> y_sub = x2y.get(x).tailSet(y);
                for (int x_tmp : x_sub) {
                    for (int y_tmp : y_sub) {
                        long l = 0;
                        l |= x_tmp;
                        l <<= 32;
                        l |= y_tmp;
                        if (set.contains(l)) {
                            int tmp = Math.abs(y_tmp - y) * Math.abs(x_tmp - x);
                            if (res == 0 && tmp != 0) {
                                System.out.println(tmp);
                                res = tmp;
                            } else if (res != 0 && tmp != 0) {
                                System.out.println(tmp);
                                res = Math.min(res, tmp);
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
