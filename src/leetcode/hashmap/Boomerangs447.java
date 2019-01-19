package leetcode.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。 找到所有回旋镖的数量。你可以假设 n 最大为
 * 500，所有点的坐标在闭区间 [-10000, 10000] 中。 示例: 输入: [[0,0],[1,0],[2,0]]
 *
 * 输出: 2 解释: 两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 */
public class Boomerangs447 {
    public static void main(String[] args) {
        Boomerangs447 boomerangs447 = new Boomerangs447();
        System.out.println(boomerangs447.numberOfBoomerangs(new int[][] {
            {0, 0},
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1}
        }));
    }

    public int numberOfBoomerangs(int[][] points) {
        Map<int[], Map<Long, Integer>> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];
                long dis = dx * dx + dy * dy;
                if (!map.containsKey(points[i])) {
                    map.put(points[i], new HashMap<>());
                }

                map.get(points[i]).put(dis, map.get(points[i]).getOrDefault(dis, 0) + 1);

                if (!map.containsKey(points[j])) {
                    map.put(points[j], new HashMap<>());
                }
                map.get(points[j]).put(dis, map.get(points[j]).getOrDefault(dis, 0) + 1);
            }
        }

        int res = 0;
        for (Map.Entry<int[], Map<Long, Integer>> entry : map.entrySet()) {
            for (Map.Entry<Long, Integer> entry1 : entry.getValue().entrySet()) {
                if (entry1.getValue() >= 2) {
                    int tmp = 1, tmp2 = 1;
                    for (int i = entry1.getValue(); i > 1; i--) {
                        tmp *= i;
                    }
                    for (int i = entry1.getValue() - 2; i > 1; i--) {
                        tmp2 *= i;
                    }
                    res += (tmp / tmp2);
                }
            }
        }
        return res;
    }

    /**
     * 最优解
     *
     * @param p
     * @return
     */
    public int numberOfBoomerangs2(int[][] p) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>(p.length);
        for (int[] i : p) {
            for (int[] j : p) {
                int dx = i[0] - j[0];
                int dy = i[1] - j[1];
                int d = dx * dx + dy * dy;
                Integer value = map.get(d);
                if (value != null) {
                    //将A(m,n)转化为递推算法
                    count += 2 * value;
                    map.put(d, value + 1);
                } else
                    map.put(d, 1);
            }
            map.clear();
        }
        return count;
    }
}
