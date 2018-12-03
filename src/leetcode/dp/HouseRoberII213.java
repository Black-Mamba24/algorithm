package leetcode.dp;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,2]
 * 输出: 3
 * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * <p>
 * 思路：计算0 - n-1 和1 - n取最大值，now表示当前获得的金额，last为now的前一次获得的金额。遍历的第i个房子需要判断是否要偷。
 * 环形题目：1. 再new一个相同的数组，拼接到原数组后面，需要遍历至少一次
 *         2. 本题思路，只遍历一次
 *         3. 环形取余
 * Created by zhaiyi on 2018/11/2.
 */
public class HouseRoberII213 {
    public static void main(String[] args) {
        HouseRoberII213 houseRoberII213 = new HouseRoberII213();
        System.out.println(houseRoberII213.rob(new int[]{2, 3, 2}));
    }

    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        } else if (len == 1) {
            return nums[0];
        }

        int last = 0, now = 0;

        for (int i = 0; i < len - 1; i++) {
            int tmp = last;
            last = now;
            now = Math.max(tmp + nums[i], now);
        }
        int res1 = Math.max(last, now);
        last = now = 0;
        for (int i = 1; i < len; i++) {
            int tmp = last;
            last = now;
            now = Math.max(tmp + nums[i], now);
        }
        int res2 = Math.max(last, now);
        return Math.max(res1, res2);
    }
}
