package 初级算法.排序和搜索;

/**
 * @ClassName: No_0088_Merge_Sorted_Array
 * @Description:
 *
 * 0088. 合并两个有序数组
 *
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * @Author: XieQing
 * @Date: 2018/11/6 09:59
 * @Version: 1.0
 */
public class No_0088_Merge_Sorted_Array {
    class SolutionA {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int index1 = m - 1;
            int index2 = n - 1;
            int index = m + n - 1;
            while (index2 >= 0 && index1 >= 0) {
                if (nums1[index1] > nums2[index2]) {
                    nums1[index] = nums1[index1];
                    index1--;
                } else {
                    nums1[index] = nums2[index2];
                    index2--;
                }
                index--;
            }
            for (int i = 0; i <= index2; i++) {
                nums1[i] = nums2[i];
            }
        }
    }

}
