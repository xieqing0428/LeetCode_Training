import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: No_1_Two_Sum
 * @Description:
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * @Author: XieQing
 * @Date: 2018/10/29 16:11
 * @Version: 1.0
 */
public class No_001_Two_Sum {
    class SolutionA {
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                for ( int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == target - nums[i]) {
                        return new int[]{i, j};
                    }
                }
            }
            return null;
        }
    }
    class SolutionB {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (map.containsKey(complement)) {
                    return new int[] { map.get(complement), i };
                }
                map.put(nums[i], i);
            }
            return null;
        }
    }

    /**
     * 桶排序，暂时没看懂
     */
    class SolutionC {
        public int[] twoSum(int[] nums, int target) {
            final int il = nums.length;
            int il2 = (il >> 2) - 1;

            int pot = 2;
            while((il2 >>= 1) > 0) {
                pot <<= 1;
            }
            final int bitMod = pot - 1;
            final int[] bucket = new int[pot];
            final int[] linked = new int[il];

            final int firstVal = nums[0];

            for (int i = 1; i < il; i++) {
                int currNum = nums[i];
                int complement = target - currNum;

                if (complement == firstVal) {
                    return new int[] { 0, i };
                }

                int complementLLIndex = bucket[complement & bitMod];
                while(complementLLIndex != 0) {
                    if(nums[complementLLIndex] == complement) {
                        //Found
                        return new int[] { complementLLIndex, i };
                    }
                    complementLLIndex = linked[complementLLIndex];
                }
                int currNumLLIndex = currNum & bitMod;
                linked[i] = bucket[currNumLLIndex];
                bucket[currNumLLIndex] = i;
            }
            return null;
        }
    }
}
