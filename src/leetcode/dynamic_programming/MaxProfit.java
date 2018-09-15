package leetcode.dynamic_programming;

/**
 *
 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。

 注意你不能在买入股票前卖出股票。

 示例 1:

 输入: [7,1,5,3,6,4]
 输出: 5
 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 示例 2:

 输入: [7,6,4,3,1]
 输出: 0
 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * Created by zhaiyi on 2018/8/30.
 */
public class MaxProfit {

    //思路为：找整个序列中所有上升段，即合计的利润>0的区域，否则利润置为0。计算所有上升段中极差最大的。
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int max = 0, profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit += prices[i] - prices[i - 1];
            if (profit > 0) {
                max = Math.max(max, profit);
            } else {
                profit = 0;
            }
        }
        return max;
    }

    //这种方法更好理解，思路为：想要计算最大差值，就要用当前的值 - 前面最小值，并对所有位置的最大利润取最大值，当出现更小时更新当前最小值。也是寻找最大上升段。
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        //边界
        int minPrice = prices[0], maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(prices[i] - minPrice, maxProfit);
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }
        return maxProfit;
    }
}
