package leetcode.recursion.back_tracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 示例:
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Subset78 {
    public static void main(String[] args) {
        Subset78 subset78 = new Subset78();
        System.out.println(subset78.subsets(new int[]{1, 2, 3}));
    }

    public boolean[] bs;
    public int[] nums;
    public List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        this.bs = new boolean[nums.length];
        this.nums = nums;
        find(0);
        return res;
    }

    public void find(int index) {
        if (index == bs.length) {
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < index; i++) {
                if (bs[i]) {
                    l.add(nums[i]);
                }
            }
            res.add(l);
        } else {
            bs[index] = true;
            find(index + 1);
            bs[index] = false;
            find(index + 1);
        }
    }
}
