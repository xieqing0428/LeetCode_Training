package 初级算法.动态规划;

/**
 * @ClassName: No_0121_Best_Time_to_Buy_and_Sell_Stock
 * @Description:
 *
 * 0121. 买卖股票的最佳时机
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * 注意你不能在买入股票前卖出股票。
 * @Author: XieQing
 * @Date: 2018/11/6 14:17
 * @Version: 1.0
 */
public class No_0121_Best_Time_to_Buy_and_Sell_Stock {
    class SolutionA {
        public int maxProfit(int[] prices) {
            int len = prices.length;
            if (len == 0) {
                return 0;
            }
            int max = 0;
            int min = Integer.MAX_VALUE;
            int temp;
            int result = 0;
            for (int i = 0; i < len; i++) {
                temp = min;
                min = Math.min(min, prices[i]);
                if (temp != min) {
                    max = prices[i];
                } else {
                    max = Math.max(max, prices[i]);
                }
                result = Math.max(result, max - min);
            }
            return result;
        }
    }
    class SolutionA_1 {
        public int maxProfit(int prices[]) {
            int minprice = Integer.MAX_VALUE;
            int maxprofit = 0;
            for (int i = 0; i < prices.length; i++) {
                if (prices[i] < minprice)
                    minprice = prices[i];
                else if (prices[i] - minprice > maxprofit)
                    maxprofit = prices[i] - minprice;
            }
            return maxprofit;
        }
    }
}
