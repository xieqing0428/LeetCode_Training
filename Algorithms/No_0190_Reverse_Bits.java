package 初级算法.其他;

/**
 * @ClassName: No_0190_Reverse_Bits
 * @Description:
 *
 * 0190. 颠倒二进制位
 *
 * 颠倒给定的 32 位无符号整数的二进制位。
 * 进阶:
 * 如果多次调用这个函数，你将如何优化你的算法？
 * @Author: XieQing
 * @Date: 2018/11/6 22:16
 * @Version: 1.0
 */
public class No_0190_Reverse_Bits {
    public class SolutionA {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            int result = 0;
            for (int i = 0; i < 32; i++, n >>>= 1) {
                result = (result << 1) | (n & 1);
            }
            return result;
        }
    }
}
