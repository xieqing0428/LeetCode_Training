package 初级算法.字符串;

/**
 * @ClassName: No_0007_Reverse_Integer
 * @Description:
 *
 * 0007. 整数反转
 *
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 * @Author: XieQing
 * @Date: 2018/10/30 19:55
 * @Version: 1.0
 */
public class No_0007_Reverse_Integer {
    class SolutionA {
        public int reverse(int x) {
            int max = (1 << 31) - 1;
            int maxHead;
            int temp;
            int tempTail;
            boolean mark = true;

            if (x < 0) {
                temp = -x;
            } else {
                temp = x;
            }
            int result = 0;
            for (int i = 1000000000; temp / 10 > 0 || temp % 10 > 0; temp = temp / 10, i = i / 10) {
                result = result * 10 + (temp % 10);
                if (temp / i > 0 && mark) {
                    maxHead = max / i;
                    tempTail = temp % 10;
                    max = max - maxHead * i;
                    if (maxHead > tempTail) {
                        mark = false;
                    }
                    if (maxHead < tempTail) {
                        return 0;
                    }
                }
            }
            if (x < 0) {
                result = -result;
            }
            return result;
        }
    }
    class SolutionB {
        public int reverse(int x) {
            int max = Integer.MAX_VALUE / 10;
            int min = Integer.MIN_VALUE / 10;
            int maxPop = Integer.MAX_VALUE % 10;
            int minPop = Integer.MIN_VALUE % 10;
            int result = 0;
            while (x != 0) {
                int pop = x % 10;
                x /= 10;
                if (result > max || (result == max && pop > maxPop)) {
                    return 0;
                }
                if (result < min || (result == min && pop < minPop)) {
                    return 0;
                }
                result = result * 10 + pop;
            }
            return result;
        }
    }
}
