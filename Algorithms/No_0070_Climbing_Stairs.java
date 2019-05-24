package 初级算法.动态规划;

/**
 * @ClassName: No_0070_Climbing_Stairs
 * @Description:
 *
 * 0070. 爬楼梯
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * @Author: XieQing
 * @Date: 2018/11/6 13:45
 * @Version: 1.0
 */
public class No_0070_Climbing_Stairs {
    class SolutionA {
        public int climbStairs(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i-1] + dp[i-2];
            }
            return dp[n];
        }
    }
    class SolutionB {
        public int climbStairs(int n) {
            if(n==0) return 0;
            if(n==1) return 1;
            if(n==2) return 2;
            int a = 1;
            int b = 2;
            int result = 0;
            for(int i = 2;i<n;i++){
                result = a+b;
                a = b;
                b = result;
            }
            return result;
        }
    }
}
