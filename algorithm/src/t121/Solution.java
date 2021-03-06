package t121;

/**
 * 121. 买卖股票的最佳时机
 * <p>
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意你不能在买入股票前卖出股票。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Chan
 * @since 2020/3/9
 */
public class Solution {
    /**
     * 计算最大收益
     *
     * @param prices 股票价格数组
     * @return int
     */
    public int maxProfit(int[] prices) {
        if (prices.length <= 0) {
            return 0;
        }
        /*
        动态规划
        第i天卖出股票的最大收益 = max(前i-1卖出股票的最大收益，当天卖出的收益)
        当天卖出股票的收益 = 当天价格 - 前i-1天最小价格

        第i天的最小价格 = min(前i-1天的最小价格, 当天价格)
         */
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int price : prices) {
            maxProfit = Math.max(maxProfit, price - minPrice);
            minPrice = Math.min(minPrice, price);
        }

        return maxProfit;
    }
}

/*
示例 1:

输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。

示例 2:

输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
