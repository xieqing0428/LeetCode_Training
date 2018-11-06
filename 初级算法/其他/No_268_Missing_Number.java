/**
 * @ClassName: No_268_Missing_Number
 * @Description:
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 * @Author: XieQing
 * @Date: 2018/11/6 22:26
 * @Version: 1.0
 */
public class No_268_Missing_Number {
    class SolutionA {
        public int missingNumber(int[] nums) {
            // 空间复杂度O(n)
            boolean[] temp = new boolean[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                temp[nums[i]] = true;
            }
            for (int i = 0; i <= nums.length; i++) {
                if (!temp[i]) {
                    return i;
                }
            }
            return 0;
        }
    }
    class SolutionB {
        public int missingNumber(int[] nums) {
            int n = nums.length;
            int sum = 0;
            int sum2 = n * (n + 1) /2;
            for(int i = 0; i < n; i++){
                sum += nums[i];
            }

            return sum2 - sum;
        }
    }
}
