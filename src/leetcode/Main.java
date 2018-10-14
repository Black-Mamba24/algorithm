package leetcode;

import java.util.*;

/**
 * Created by zhaiyi on 2018/10/14.
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        List<List<Integer>> res = new ArrayList<>();
        Set<String> set1 = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (set.contains(-nums[i] - nums[j])) {
                    String s = "" + nums[i] + nums[j] + (-nums[i] - nums[j]);
                    if (!set1.contains(s)) {
                        List<Integer> l = new ArrayList<>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(-nums[i] - nums[j]);
                        res.add(l);
                        set1.add(s);
                    }
                }
            }
        }
        return res;
    }
}
