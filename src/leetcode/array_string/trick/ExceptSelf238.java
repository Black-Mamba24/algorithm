package leetcode.array_string.trick;

/**
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。 示例:
 * 输入: [1,2,3,4] 输出: [24,12,8,6] 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * 进阶： 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 */
public class ExceptSelf238 {
    public static void main(String[] args) {
        ExceptSelf238 exceptSelf238 = new ExceptSelf238();
        exceptSelf238.productExceptSelf(new int[] {1, 2, 3, 4});
    }

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] l2r = new int[len];
        int[] r2l = new int[len];
        l2r[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            l2r[i] = l2r[i - 1] * nums[i];
        }
        r2l[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            r2l[i] = r2l[i + 1] * nums[i];
        }
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int l_idnex = i - 1;
            int r_index = i + 1;
            res[i] = (l_idnex < 0 ? 1 : l2r[l_idnex]) * (r_index >= len ? 1 : r2l[r_index]);
        }
        return res;
    }
}
