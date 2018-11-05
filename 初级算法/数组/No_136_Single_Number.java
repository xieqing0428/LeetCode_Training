import java.util.Arrays;

/**
 * @ClassName: No_136_Single_Number
 * @Description:
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * @Author: XieQing
 * @Date: 2018/10/23 22:42
 * @Version: 1.0
 */
public class No_136_Single_Number {
    class SolutionA {
        public int singleNumber(int[] nums) {
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i += 2) {
                if (i == nums.length - 1 || nums[i] != nums[i + 1]) {
                    return nums[i];
                }
            }
            return 0;
        }
    }
    class SolutionB {
        public int singleNumber(int[] nums) {
            //两个相同的数异或结果为0，一个数跟0异或是这个数本身
            int test = 0;
            for ( int i = nums.length -1 ; i >= 0; --i) {
                test ^= nums[i];
            }
            return test;
        }
    }
}
