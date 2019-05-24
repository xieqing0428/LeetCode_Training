package 初级算法.数组;

/**
 * @ClassName: No_0283_Move_Zeroes
 * @Description:
 *
 * 0283. 移动零
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * @Author: XieQing
 * @Date: 2018/10/25 22:31
 * @Version: 1.0
 */
public class No_0283_Move_Zeroes {
    class SolutionA {
        public void moveZeroes(int[] nums) {
            int zeroPos = findFirstZero(nums);
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] != 0 && j > zeroPos) {
                    nums[zeroPos] = nums[j];
                    nums[j] = 0;
                    zeroPos = findFirstZero(nums);
                }
            }
        }
        public int findFirstZero(int[] nums) {
            for(int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    return i;
                }
            }
            return nums.length;
        }
    }
    class SolutionB {
        public void moveZeroes(int[] nums) {
            int i = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] != 0) {
                    nums[i++] = nums[j];
                }
            }
            for (int k = i; k < nums.length; k++) {
                nums[k] = 0;
            }
        }
    }
}
