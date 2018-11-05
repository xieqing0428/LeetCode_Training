/**
 * @ClassName: No_66_Plus_One
 * @Description:
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * @Author: XieQing
 * @Date: 2018/10/24 22:40
 * @Version: 1.0
 */
public class No_066_Plus_One {
    class SolutionA {
        public int[] plusOne(int[] digits) {
            for (int i = digits.length - 1; i >= 0; i--) {
                if (digits[i] != 9) {
                    digits[i] += 1;
                    return digits;
                } else {
                    digits[i] = 0;
                }
            }
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }
    }
}
