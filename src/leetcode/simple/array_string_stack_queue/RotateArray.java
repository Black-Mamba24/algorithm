package leetcode.simple.array_string_stack_queue;

/**
 * Created by zhaiyi on 2018/9/4.
 */
public class RotateArray {
    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        rotateArray.rotate(new int[] {1,2,3,4,5,6,7}, 3);
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        for (int i = 0; i < k / 2; i++) {
            int tmp = nums[i];
            nums[i] = nums[k - i - 1];
            nums[k - i - 1] = tmp;
        }
        for (int i = k, j = 0; i < k + (nums.length - k) / 2; i++, j++) {
            int tmp = nums[i];
            nums[i] = nums[nums.length - j - 1];
            nums[nums.length - j - 1] = tmp;
        }
        for (int i = 0; i < nums.length / 2; i++) {
            int tmp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = tmp;
        }
        System.out.println();
    }
}
