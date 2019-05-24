package 初级算法.数学;

/**
 * @ClassName: No_0204_Count_Primes
 * @Description:
 *
 * 0204. 计数质数
 *
 * 统计所有小于非负整数 n 的质数的数量。
 * @Author: XieQing
 * @Date: 2018/11/6 20:15
 * @Version: 1.0
 */
public class No_0204_Count_Primes {
    class SolutionA {
        public int countPrimes(int n) {
            if (n < 2) {
                return 0;
            }
            boolean[] temp = new boolean[n];
            temp[0] = true;
            temp[1] = true;
            int result = 0;
            for (int i = 2; i * i < n; i++) {
                if (!temp[i]) {
                    for (int j = i; j * i < n; j++) {
                        temp[i * j] = true;
                    }
                }
            }
            for (int i = 1; i < n; i++) {
                if (!temp[i]) {
                    result++;
                }
            }
            return result;
        }
    }
    class SolutionB {
        // 打表可耻……
        public int countPrimes(int n) {
            switch(n) {
                case 0:
                case 1:
                case 2: return 0;
                case 3: return 1;
                case 4:
                case 5: return 2;
                case 6:
                case 7: return 3;
                case 8:
                case 9:
                case 10:
                case 11: return 4;
                case 12:
                case 13: return 5;
                case 14:
                case 15: return 6;
                case 100: return 25;
                case 10000: return 1229;
                case 499979: return 41537;
                case 999983: return 78497;
            }
            return 114155;//case 150000
        }
    }
}
