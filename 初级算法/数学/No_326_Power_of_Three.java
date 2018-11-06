/**
 * @ClassName: No_326_Power_of_Three
 * @Description: 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 * @Author: XieQing
 * @Date: 2018/11/6 20:31
 * @Version: 1.0
 */
public class No_326_Power_of_Three {
    class SolutionA {
        public boolean isPowerOfThree(int n) {
            if (n == 1) {
                return true;
            }
            int temp = n % 3;
            int index = n / 3;
            if (temp == 0 && index == 1) {
                return true;
            }
            return temp == 0 && index > 0 && isPowerOfThree(index);
        }
    }

    class SolutionB {
        public boolean isPowerOfThree(int n) {
            if (n == 1) { return true; }
            while (true) {
                if (n / 3 == 1 && n % 3 == 0) { return true; }
                if (n / 3 == 0) { return false; }
                if (n % 3 == 1 || n % 3 == 2) { return false; }
                n /= 3;
            }
        }
    }

    class SolutionC {
        // 类似打表……
        public boolean isPowerOfThree(int n) {
            return n > 0 && (1162261467 % n) == 0;
        }
    }
}
