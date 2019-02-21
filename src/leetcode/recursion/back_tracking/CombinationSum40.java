package leetcode.recursion.back_tracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * Created by zhaiyi on 2019/2/19.
 */
public class CombinationSum40 {
    public static void main(String[] args) {
        CombinationSum40 combinationSum40 = new CombinationSum40();
        System.out.println(combinationSum40.combinationSum2(new int[] {10, 1, 2, 7, 6, 1, 5}, 8));
    }

//    public Set<Integer> set = new HashSet<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        find(candidates, target, new ArrayList<>(), res, 0, 0);
        return res;
    }

    public void find(int[] candidates, int target, List<Integer> list, List<List<Integer>> res, int sum, int index) {
        if (sum == target) {
            List<Integer> tmp = new ArrayList<>(list);
            res.add(new ArrayList<>(tmp));
        } else if (sum < target) {
            for (int i = index; i < candidates.length; i++) {
                int c = candidates[i];
                if (i > index && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                if (c + sum <= target) {
                    list.add(c);
                    find(candidates, target, list, res, sum + c, i + 1);
                    list.remove(list.size() - 1);
                } else {
                    break;
                }
            }
        }
    }
}
