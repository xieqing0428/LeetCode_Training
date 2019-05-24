package 初级算法.数组;

/**
 * @ClassName: No_0026_Remove_Duplicates_From_Sorted_Array
 * @Description:
 *
 * 0026. 删除排序数组中的重复项
 *
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * @Author: XieQing
 * @Date: 2018/10/23 20:48
 * @Version: 1.0
 */
public class No_0026_Remove_Duplicates_from_Sorted_Array {
    class SolutionA {
        public int removeDuplicates(int[] nums) {
            int len = 0;
            // 双指针
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > nums[len]) {
                    nums[++len] = nums[i];
                }
            }
            return ++len;
        }
    }
    class SolutionB {
        public int removeDuplicates(int[] nums) {
            // 官方
            if (nums.length == 0) return 0;
            int i = 0;
            for (int j = 1; j < nums.length; j++) {
                if (nums[j] != nums[i]) {
                    i++;
                    nums[i] = nums[j];
                }
            }
            return i + 1;
        }
    }
}
