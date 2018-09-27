package leetcode.greedy;

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

 贪心思路：寻找前面K个价格最大值，当max - 当前价格 >= fee，说明此时在max处卖出不会卖早，有价值。
 要注意的是当前利润curP不能用max - min - fee，原因是max可能在min之前，只能用当前价格 - min - fee
 * Created by zhaiyi on 2018/9/27.
 */
public class MaxProfileFee714 {
    public int maxProfit(int[] prices, int fee) {
        int min, max, curP = 0, pro = 0;
        min = max = prices[0];
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i]);
            curP = Math.max(curP, prices[i] - min - fee);
            if (max - prices[i] >= fee) {
                pro += curP;
                curP = 0;
                min = prices[i];
                max = prices[i];
            }
        }
        return pro + curP;
    }
}
