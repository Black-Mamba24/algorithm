package leetcode.dp;

import java.util.List;

public class TriangleMinimumTotal120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int[] sum = new int[triangle.size()];
        for (int i = 0; i < triangle.get(triangle.size() - 1).size(); i++) {
            sum[i] = triangle.get(triangle.size() - 1).get(i);
        }
        for (int i = triangle.get(triangle.size() - 1).size() - 1; i >= 0; i--) {
            List<Integer> line = triangle.get(i);
            for (int j = 0; j < line.size(); j++) {
                sum[j] = line.get(j) + Math.min(sum[j], sum[j + 1]);
            }
        }
        return sum[0];
    }
}
