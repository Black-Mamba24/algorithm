package leetcode.recursion.back_tracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 *
 * 精髓：排序 + index = 去重
 * Created by zhaiyi on 2019/2/19.
 */
public class CombinationSum39 {
    public static void main(String[] args) {
        CombinationSum39 combinationSum39 = new CombinationSum39();
        System.out.println(combinationSum39.combinationSum(new int[] {2, 3, 6, 7}, 10));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
                if (c + sum <= target) {
                    list.add(c);
                    find(candidates, target, list, res, sum + c, i);
                    list.remove(list.size() - 1);
                } else {
                    break;
                }
            }
        }
    }
}
