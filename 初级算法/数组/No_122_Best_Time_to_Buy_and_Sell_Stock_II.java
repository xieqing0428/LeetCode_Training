/**
 * @ClassName: No_26_Remove_Duplicates_From_Sorted_Array
 * @Description:
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * @Author: XieQing
 * @Date: 2018/10/23 20:48
 * @Version: 1.0
 */
public class No_122_Best_Time_to_Buy_and_Sell_Stock_II {
    class SolutionA {
        public int maxProfit(int[] prices) {
            int profit = 0;
            for (int i = 1; i < prices.length; i++) {
                // 贪心
                if (prices[i-1] < prices[i]) {
                    profit += prices[i] - prices[i-1];
                }
            }
            return profit;
        }
    }
}
