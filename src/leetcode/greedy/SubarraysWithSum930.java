package leetcode.greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * 在由若干 0 和 1  组成的数组 A 中，有多少个和为 S 的非空子数组。



 示例：

 输入：A = [1,0,1,0,1], S = 2
 输出：4
 解释：
 如下面黑体所示，有 4 个满足题目要求的子数组：
 [1,0,1,0,1]
 [1,0,1,0,1]
 [1,0,1,0,1]
 [1,0,1,0,1]
 * Created by zhaiyi on 2018/10/28.
 */
public class SubarraysWithSum930 {
    public static void main(String[] args) {
        SubarraysWithSum930 subarraysWithSum930 = new SubarraysWithSum930();
        System.out.println(subarraysWithSum930.numSubarraysWithSum(new int[]{0,1,1,1,1}, 2));
    }

    public int numSubarraysWithSum(int[] A, int S) {
        Map<Integer, Integer> map = new HashMap<>();
        if (S != 0) {
            map.put(0, 1);
        }
        int sum = 0, res = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        if (S != 0) {

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getKey() >= S) {
                    int tmp = entry.getValue() * map.getOrDefault(entry.getKey() - S, 0);
                    res += tmp;
                }
            }
        } else {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getKey() == 0) {
                    res += (1 + entry.getValue()) * entry.getValue() / 2;
                } else if (entry.getValue() > 1) {
                    res += (1 + entry.getValue() - 1) * (entry.getValue() - 1) / 2;
                }
            }
        }

        return res;
    }
}
