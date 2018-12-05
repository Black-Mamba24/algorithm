package leetcode.recursion.back_tracking;

import java.util.ArrayList;
import java.util.List;

public class Subset78 {
    public static void main(String[] args) {
        Subset78 subset78 = new Subset78();
        System.out.println(subset78.subsets(new int[]{1,2,3}));
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        find(res, new boolean[nums.length], nums, 0);
        return res;
    }

    public void find(List<List<Integer>> res, boolean[] bs, int[] nums, int index) {
        if (index == bs.length) {
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < index; i++) {
                if (bs[i]) {
                    l.add(nums[i]);
                }
            }
            res.add(l);
        } else {
            for (int i = index; i < nums.length; i++) {
                bs[i] = true;
                find(res, bs, nums, i + 1);
                bs[i] = false;
            }
        }
    }
}
