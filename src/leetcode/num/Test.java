package leetcode.num;

/**
 * Created by zhaiyi on 2018/9/8.
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.findDuplicate(new int[]{1,3,4,2,2,});
    }
    public int findDuplicate(int[] nums) {
        int min, max, sum = 0;
        min = max = nums[0];
        for (int i = 0; i < nums[i]; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
            sum += nums[i];
        }
        return (sum - (min + max) * (max - min + 1) / 2) / (nums.length - (max - min + 1));
    }
}
