package 初级算法.动态规划;

/**
 * @ClassName: No_0053_Maximum_Subarray
 * @Description:
 *
 * 0053. 最大子序和
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 进阶:
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * @Author: XieQing
 * @Date: 2018/11/6 15:54
 * @Version: 1.0
 */
public class No_0053_Maximum_Subarray {
    class SolutionA {
        public int maxSubArray(int[] nums) {
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            int max = dp[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }
}
