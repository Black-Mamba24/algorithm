package leetcode.recursion.back_tracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 */
public class CombinationSum216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        find(k, n, 0, new ArrayList<>(), res, 0);
        return res;
    }

    public void find(int k, int target, int sum, List<Integer> list, List<List<Integer>> res, int index) {
        if (target == sum && list.size() == k) {
            res.add(new ArrayList<>(list));
        } else if (list.size() < k) {
            for (int i = index; i < 9; i++) {
                list.add(i + 1);
                find(k, target, sum + i + 1, list, res, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
