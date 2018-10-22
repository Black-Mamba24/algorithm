package leetcode.dp;

import java.util.HashSet;
import java.util.Set;

/**
 * 我们有一个非负整数数组 A。

 对于每个（连续的）子数组 B = [A[i], A[i+1], ..., A[j]] （ i <= j），我们对 B 中的每个元素进行按位或操作，获得结果 A[i] | A[i+1] | ... | A[j]。

 返回可能结果的数量。 （多次出现的结果在最终答案中仅计算一次。）

 思路：这道题最初的想法是维护一个二维数组，下一层的值是上一层值执行或操作算的。
 但每一行存在重复数字，因此用一个set表示上一行的所有值，遍历set或操作，计算当前行的值的集合。
 * Created by zhaiyi on 2018/10/19.
 */
public class SubarrayBitOr898 {
    public static void main(String[] args) {
        SubarrayBitOr898 subarrayBitOr898 = new SubarrayBitOr898();
        System.out.println(subarrayBitOr898.subarrayBitwiseORs(new int[]{1,2,4}));
    }

    public int subarrayBitwiseORs(int[] A) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> level = new HashSet<>(), level_tmp;
        for (int i = 0; i < A.length; i++) {
            level_tmp = new HashSet<>();
            level_tmp.add(A[i]);
            for (int num : level) {
                level_tmp.add(num | A[i]);
            }
            level = level_tmp;
            res.addAll(level);
        }
        return res.size();
    }
}
