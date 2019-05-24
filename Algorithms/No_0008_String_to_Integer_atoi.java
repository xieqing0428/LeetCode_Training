package 初级算法.字符串;

/**
 * @ClassName: No_0008_String_to_Integer_atoi
 * @Description:
 *
 * 0008. 字符串转换整数 (atoi)
 *
 * 实现 atoi，将字符串转为整数。
 * 该函数首先根据需要丢弃任意多的空格字符，直到找到第一个非空格字符为止。如果第一个非空字符是正号或负号，选取该符号，并将其与后面尽可能多的连续的数字组合起来，这部分字符即为整数的值。如果第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * 字符串可以在形成整数的字符后面包括多余的字符，这些字符可以被忽略，它们对于函数没有影响。
 * 当字符串中的第一个非空字符序列不是个有效的整数；或字符串为空；或字符串仅包含空白字符时，则不进行转换。
 * 若函数不能执行有效的转换，返回 0。
 * 说明：
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。如果数值超过可表示的范围，则返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 * @Author: XieQing
 * @Date: 2018/10/31 11:56
 * @Version: 1.0
 */
public class No_0008_String_to_Integer_atoi {
    class SolutionA {
        public int myAtoi(String str) {
            str = str.trim();
            if (str.isEmpty() || str.charAt(0) != '-' && str.charAt(0) != '+' && !(str.charAt(0) >= '0' && str.charAt(0) <= '9')) {
                return 0;
            }
            boolean markN = false;
            int len = str.length();
            int result = 0;
            final int MAX = Integer.MAX_VALUE / 10;
            for (int i = 0; i < len; i++) {
                if (i == 0 && str.charAt(i) == '-') {
                    markN = true;
                    continue;
                }
                if (i == 0 && str.charAt(i) == '+') {
                    continue;
                }
                if (!(str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
                    break;
                }
                if (result >= MAX) {
                    if (!markN && ((result== MAX && str.charAt(i) > '7') || result > MAX)) {
                        return Integer.MAX_VALUE;
                    }
                    if (markN && ((result== MAX && str.charAt(i) > '8') || result > MAX)) {
                        return Integer.MIN_VALUE;
                    }
                }
                result = 10 * result + str.charAt(i) - '0';
            }
            if (markN) {
                result = -result;
            }
            return result;
        }
    }
    class SolutionB {
        public int myAtoi(String str) {
            int len = str.length();
            if (len == 0) {
                return 0;
            }
            char[] cs = str.toCharArray();
            int i = 0;
            while (i < len && cs[i++] == ' ') {

            }
            i--;
            char c1 = cs[i];
            int sig = 1;
            if ((c1 > '9' || c1 < '0')) {
                if (c1 == '-') {
                    sig = -1;
                    i++;
                } else if (c1 == '+') {
                    i++;
                } else {
                    return 0;
                }
            }
            long v = 0;
            for (; i < len; i++) {
                char c = cs[i];
                if (c < '0' || c > '9') {
                    break;
                }
                v = v * 10 + (c - '0');
                if (v * sig > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                } else if (v * sig < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            }
            return (int) (v * sig);
        }
    }
}
