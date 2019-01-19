package leetcode.array_string.normal;

public class OneCount485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                cur += 1;
                max = Math.max(cur, max);
            } else {
                cur = 0;
            }
        }
        return max;
    }
}
