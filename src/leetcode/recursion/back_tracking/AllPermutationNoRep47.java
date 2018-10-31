package leetcode.recursion.back_tracking;

import java.util.*;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * Created by zhaiyi on 2018/10/26.
 */
public class AllPermutationNoRep47 {

    /* 方法一：沿用全排列方法，增加判断list hashCode，重复list hashCode相同，但相对较慢 */
    public List<List<Integer>> res = new ArrayList<>();
    public Set<Integer> set = new HashSet<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        de_co(nums, 0, nums.length - 1);
        return res;
    }

    public void de_co(int[] nums, int start, int end) {
        if (start == end) {
            List<Integer> list = new ArrayList<>();
            for(int n : nums) {
                list.add(n);
            }
            if (!set.contains(list.hashCode())) {
                res.add(list);
                set.add(list.hashCode());
            }
        } else {
            for (int i = start; i <= end; i++) {
                swap(nums, start, i);
                de_co(nums, start + 1, end);
                swap(nums, start, i);
            }
        }
    }

    public void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

    /* 方法二：没理解 todo */
    List<List<Integer>> alllist = new LinkedList<List<Integer>>();

    public List<List<Integer>> permuteUnique2(int[] nums) {
        dfs(nums, 0);
        return alllist;
    }

    public void dfs(int[] nums, int start) {
        if (start == nums.length) {
            List<Integer> list = new LinkedList<Integer>();
            for (int i = 0; i < nums.length; i++) list.add(nums[i]);
            alllist.add(list);
        }
        for (int i = start; i < nums.length; i++) {
            boolean flag = false;
            for (int j = start + 1; j < i; j++) {
                if (nums[j] == nums[i]) flag = true;
            }
            if (flag) continue;
            int tmp = nums[start];
            nums[start] = nums[i];
            nums[i] = tmp;
            dfs(nums, start + 1);
            nums[i] = nums[start];
            nums[start] = tmp;
        }
    }
}
