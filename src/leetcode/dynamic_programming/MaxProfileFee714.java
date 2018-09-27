package leetcode.dynamic_programming;

/**
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。

 你可以无限次地完成交易，但是你每次交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。

 返回获得利润的最大值。

 示例 1:

 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
 输出: 8
 解释: 能够达到的最大利润:
 在此处买入 prices[0] = 1
 在此处卖出 prices[3] = 8
 在此处买入 prices[4] = 4
 在此处卖出 prices[5] = 9
 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.

 动态规划思路：a表示不持有当前股票的最大收益，b表示持有当前股票最大收益。
 a包括：昨天就没持有，结果是a；今天卖的，结果是b + prices[i] - fee
 b包括：今天没卖，结果是b；今天买的，结果是a -prices[i]

 * Created by zhaiyi on 2018/9/27.
 */
public class MaxProfileFee714 {
    public int maxProfit(int[] prices, int fee) {
        int a = 0;
        int b = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int c = a;
            a = Math.max(a, b + prices[i] - fee);
            b = Math.max(b, c - prices[i]);
        }
        return Math.max(a,b);
    }
}
