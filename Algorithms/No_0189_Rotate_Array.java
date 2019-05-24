package 初级算法.数组;

/**
 * @ClassName: No_0189_Rotate_Array
 * @Description:
 *
 * 0189. 旋转数组
 *
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * @Author: XieQing
 * @Date: 2018/10/23 20:55
 * @Version: 1.0
 */
public class No_0189_Rotate_Array {

    class SolutionA {
        public void rotate(int[] nums, int k) {
            int temp;
            for (int i = 0; i < k; i++) {
                temp = nums[nums.length - 1];
                for (int j = nums.length - 1; j > 0; j--) {
                    nums[j] = nums[j-1];
                }
                nums[0] = temp;
            }
        }
    }
    class SolutionB {
        public void rotate(int[] nums, int k) {
            k %= nums.length;
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
        }

        public void reverse(int[] array, int start, int end) {
            int temp;
            while (start < end) {
                temp = array[start];
                array[start] = array[end];
                array[end] = temp;
                start++;
                end--;
            }
        }
    }
}
