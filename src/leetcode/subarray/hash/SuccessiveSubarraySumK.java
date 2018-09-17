package leetcode.subarray.hash;

import java.util.HashMap;
import java.util.Map;

/**
 *
 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。

 示例 1 :

 输入:nums = [1,1,1], k = 2
 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 说明 :

 数组的长度为 [1, 20,000]。
 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。

 思路：跟在数组中快速查找是否有两个数的和是目标值相似，同时结合计算连续子数组和的方法，将累加的sum和出现数量的映射存储map。
 每次寻找sum - k，快速查找。如果能查到，表示当前sum - 查找的sum = k。
 * Created by zhaiyi on 2018/9/17.
 */
public class SuccessiveSubarraySumK {
    public static void main(String[] args) {
        SuccessiveSubarraySumK subarraySumK = new SuccessiveSubarraySumK();
        System.out.println(subarraySumK.method2(new int[] {1,1,1,1}, 2));
    }

    public int normalMethod(int[] array, int k) {
        int ans = 0;
        for(int i = 0; i < array.length; i++) {
            int sum = 0;
            int start = i;
            while (start < array.length) {
                sum += array[start++];
                if (sum == k) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public int method2(int[] array, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, ans = 0;
        map.put(0, 1);
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
