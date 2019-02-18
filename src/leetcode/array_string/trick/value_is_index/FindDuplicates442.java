package leetcode.array_string.trick.value_is_index;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicates442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int n : nums) {
            int index = Math.abs(n) - 1;
            if (nums[index] < 0) {
                res.add(Math.abs(n));
            } else {
                nums[index] = -nums[index];
            }
        }
        return res;
    }
}
