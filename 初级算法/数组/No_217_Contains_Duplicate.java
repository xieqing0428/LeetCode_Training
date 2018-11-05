import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: No_217_Contains_Duplicate
 * @Description:
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 * @Author: XieQing
 * @Date: 2018/10/23 21:11
 * @Version: 1.0
 */
public class No_217_Contains_Duplicate {
    class SolutionA {
        public boolean containsDuplicate(int[] nums) {
            Set temp = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                temp.add(nums[i]);
            }
            return temp.size() != nums.length;
        }
    }

    class SolutionB {
        public boolean containsDuplicate(int[] nums) {
            for (int i = 1; i < nums.length; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[i] > nums[j]) {
                        break;
                    } else if (nums[i] == nums[j]) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
