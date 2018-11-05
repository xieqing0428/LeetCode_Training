import java.util.Arrays;

/**
 * @ClassName: No_350_Intersection_of_Two_Arrays_II
 * @Description:
 * 给定两个数组，编写一个函数来计算它们的交集。
 * @Author: XieQing
 * @Date: 2018/10/24 21:44
 * @Version: 1.0
 */
public class No_350_Intersection_of_Two_Arrays_II {
    class SolutionA {
        public int[] intersect(int[] nums1, int[] nums2) {
            if (nums1.length == 0 || nums2.length == 0) {
                return new int[0];
            }
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int i = 0;
            int j = 0;
            int k = 0;
            int[] result = new int[Math.min(nums1.length, nums2.length)];
            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] == nums2[j]) {
                    result[k++] = nums1[i];
                    i++;
                    j++;
                } else if (nums1[i] > nums2[j]){
                    j++;
                } else {
                    i++;
                }
            }
            return Arrays.copyOf(result, k);
        }
    }
}
