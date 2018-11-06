import java.util.Arrays;
import java.util.Random;

/**
 * @ClassName: No_384_Shuffle_an_Array
 * @Description:
 * 打乱一个没有重复元素的数组。
 * @Author: XieQing
 * @Date: 2018/11/6 16:55
 * @Version: 1.0
 */
public class No_384_Shuffle_an_Array {
    class SolutionA {
        int[] reset;
        public SolutionA(int[] nums) {
            reset = nums;
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return reset;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            int[] result = Arrays.copyOf(reset, reset.length);
            Random random = new Random();
            int index, temp;
            for (int i = 0; i < result.length; i++) {
                index = random.nextInt(i + 1);
                temp = result[index];
                result[index] = result[i];
                result[i] = temp;
            }
            return result;
        }
    }

    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(nums);
     * int[] param_1 = obj.reset();
     * int[] param_2 = obj.shuffle();
     */

    class SolutionA_1 {

        private int[] original;
        private int[] values;
        private Random random;
        public SolutionA_1(int[] nums) {
            original = nums;
            values = Arrays.copyOf(nums,nums.length);
            random = new Random();
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            values = Arrays.copyOf(original,original.length);
            return values;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            int rightEnd = values.length -1;
            int r;
            while (rightEnd >0)
            {
                r = random.nextInt(rightEnd + 1);
                if(r != rightEnd)
                    swap(values,r,rightEnd);
                rightEnd--;
            }
            return values;
        }


        private void swap(int[] array, int i, int j)
        {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
