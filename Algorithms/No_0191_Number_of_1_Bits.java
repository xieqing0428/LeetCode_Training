package 初级算法.其他;

/**
 * @ClassName: No_0191_Number_of_1_Bits
 * @Description:
 *
 * 0191. 位1的个数
 *
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 * @Author: XieQing
 * @Date: 2018/11/6 21:58
 * @Version: 1.0
 */
public class No_0191_Number_of_1_Bits {
    public class SolutionA {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int result = 0;
            while (n != 0) {
                result += (n & 1);
                // 无符号移位操作
                n >>>= 1;
            }
            return result;
        }
    }

    public class SolutionA_1 {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int sum = 0;
            for (int i = 0; i < 32; i++, n >>>= 1) { if ((n & 1) == 1) { sum++; } }
            return sum;
        }
    }
}
